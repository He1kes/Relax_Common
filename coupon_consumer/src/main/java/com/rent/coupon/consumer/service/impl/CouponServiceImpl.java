package com.rent.coupon.consumer.service.impl;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.Coupon;
import com.heikes.rent_common.vo.PageResult;
import com.rent.coupon.consumer.client.CouponClient;
import com.rent.coupon.consumer.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/16
 * @Time:10:06
 */
@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponClient couponClient;

    @Override
    public Bizdto<Boolean> addCoupon(Coupon coupon) {
        return couponClient.insertCoupon(coupon);
    }

    @Override
    public Bizdto<PageResult<Coupon>> getCouponList(Integer pageNum, Integer pageSize, String couponCondition, String couponContent, Integer couponType) {
        Map<String, Object> map = new HashMap<>();
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        map.put("couponCondition", couponCondition);
        map.put("couponContent", couponContent);
        map.put("couponType", couponType);
        return couponClient.getCouponList(map);
    }
}
