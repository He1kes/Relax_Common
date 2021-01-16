package com.rent.user.consumer.client;

import com.heikes.rent_common.remote.user.UserRoleRemote;
import com.rent.user.consumer.hystrix.UserRoleClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/6
 * @Time:19:42
 */
@Component
@FeignClient(value = "user-provider", path = "userRole", fallbackFactory = UserRoleClientFallback.class)
public interface UserRoleClient extends UserRoleRemote {
}
