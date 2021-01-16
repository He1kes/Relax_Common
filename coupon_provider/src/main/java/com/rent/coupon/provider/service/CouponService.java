package com.rent.coupon.provider.service;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.Coupon;
import com.heikes.rent_common.vo.PageResult;

import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/16
 * @Time:9:40
 */
public interface CouponService {

    public boolean insertCoupon(Coupon coupon);

    Bizdto<PageResult<Coupon>> getCouponList(Map<String, Object> map);
}
