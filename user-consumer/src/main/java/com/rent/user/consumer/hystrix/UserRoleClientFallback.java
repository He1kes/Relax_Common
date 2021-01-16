package com.rent.user.consumer.hystrix;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.UserRole;
import com.rent.user.consumer.client.UserRoleClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/6
 * @Time:19:44
 */
@Component
public class UserRoleClientFallback implements FallbackFactory<UserRoleClient> {
    @Override
    public UserRoleClient create(Throwable cause) {
        return new UserRoleClient() {
            @Override
            public Bizdto<UserRole> selectByColumn(Map<String, Object> map) {
                Bizdto<UserRole> bizdto = new Bizdto<>();
                bizdto.setData(null);
                bizdto.setMessage("请求失败！");
                bizdto.setCode(StatusCode.REMOTEERROR);
                return bizdto;
            }
        };
    }
}
