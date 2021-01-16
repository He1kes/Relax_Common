package com.rent.coupon.consumer.service;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.Coupon;
import com.heikes.rent_common.vo.PageResult;
import com.rent.coupon.consumer.client.CouponClient;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/16
 * @Time:10:04
 */
public interface CouponService {

    Bizdto<Boolean> addCoupon(Coupon coupon);

    Bizdto<PageResult<Coupon>> getCouponList(Integer pageNum, Integer pageSize, String couponCondition, String couponContent, Integer couponType);
}
