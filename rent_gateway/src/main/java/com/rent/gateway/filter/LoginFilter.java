package com.rent.gateway.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/6
 * @Time:11:27
 */
@Component
public class LoginFilter implements GlobalFilter, Ordered {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        if (!request.getURI().toString().contains("/front/public/")) {
            String token = request.getHeaders().getFirst("token");
            token = token == null ? "" : token;
            String userId = (String) stringRedisTemplate.opsForHash().get(token, "userId");

            //如果未找到token中存储的值
            if (StringUtils.isBlank(userId)) {
                ServerHttpResponse response = exchange.getResponse();
                response.getHeaders().add("Content-Type", "application/json; charset=utf-8");
                //HTTP 401 没有访问权限
                response.setStatusCode(HttpStatus.CREATED);
                //响应内容
                String message = "{\"flag\":\"false\", \"code\":\"20002\", \"message\":\"未登录\", \"data\":null}";
                DataBuffer buffer = response.bufferFactory().wrap(message.getBytes());
                //请求结束，不再继续向下请求
                return response.writeWith(Mono.just(buffer));
            } else {
                //延长token时间
                stringRedisTemplate.expire(token, 30L, TimeUnit.MINUTES);
                if (request.getURI().toString().contains("/front/private/")) {
                    return chain.filter(exchange);
                } else { //request.getURI().toString().contains("/back/")
                    int roleId =  Integer.parseInt(stringRedisTemplate.opsForHash().get(token, "roleId").toString());
                    //如果不为普通用户，则放行
                    if (roleId != 4) {
                        return chain.filter(exchange);
                    } else {
                        ServerHttpResponse response = exchange.getResponse();
                        response.getHeaders().add("Content-Type", "application/json; charset=utf-8");
                        //HTTP 401 没有访问权限
                        response.setStatusCode(HttpStatus.CREATED);
                        //响应内容
                        String message = "{\"flag\":\"false\", \"code\":\"20003\", \"message\":\"权限不足\", \"data\":null}";
                        DataBuffer buffer = response.bufferFactory().wrap(message.getBytes());
                        //请求结束，不再继续向下请求
                        return response.writeWith(Mono.just(buffer));
                    }
                }

            }
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
