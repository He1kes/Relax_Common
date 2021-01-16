package com.heikes.rent_common.remote.coupon;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.Coupon;
import com.heikes.rent_common.vo.PageResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/16
 * @Time:9:42
 */
public interface CouponRemote {

    @PostMapping(value = "insertCoupon")
    Bizdto<Boolean> insertCoupon(@RequestBody Coupon coupon);

    @PostMapping(value = "getCouponList")
    Bizdto<PageResult<Coupon>> getCouponList(@RequestBody Map<String, Object> map);
}
