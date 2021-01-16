package com.rent.coupon.consumer.client;

import com.heikes.rent_common.remote.coupon.CouponRemote;
import com.rent.coupon.consumer.hystrix.CouponClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/16
 * @Time:9:53
 */
@Component
@FeignClient(value = "coupon-provider", path = "coupon", fallbackFactory = CouponClientFallback.class)
public interface CouponClient extends CouponRemote {
}
