package com.rent.user.consumer.client;

import com.heikes.rent_common.remote.user.FunctionRemote;
import com.rent.user.consumer.hystrix.FunctionClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/13
 * @Time:8:30
 */
@Component
@FeignClient(value = "user-provider", path = "function", fallbackFactory = FunctionClientFallback.class)
public interface FunctionClient extends FunctionRemote {
}
