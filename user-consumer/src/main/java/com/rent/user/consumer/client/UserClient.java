package com.rent.user.consumer.client;

import com.heikes.rent_common.remote.user.UserRemote;
import com.rent.user.consumer.hystrix.UserClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2020/12/30
 * @Time:11:24
 */
@Component
@FeignClient(value = "user-provider", path = "user", fallbackFactory = UserClientFallback.class)
public interface UserClient extends UserRemote {
}
