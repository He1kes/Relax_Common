package com.rent.user.consumer.client;

import com.heikes.rent_common.remote.user.RoleRemote;
import com.rent.user.consumer.hystrix.RoleClientFallback;
import com.rent.user.consumer.hystrix.UserRoleClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/11
 * @Time:9:59
 */
@Component
@FeignClient(value = "user-provider", path = "role", fallbackFactory = RoleClientFallback.class)
public interface RoleClient extends RoleRemote {
}
