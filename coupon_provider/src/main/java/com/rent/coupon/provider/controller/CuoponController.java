package com.rent.coupon.provider.controller;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.Coupon;
import com.heikes.rent_common.remote.coupon.CouponRemote;
import com.heikes.rent_common.vo.PageResult;
import com.rent.coupon.provider.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/16
 * @Time:9:38
 */
@RestController
@RequestMapping(value = "/coupon")
public class CuoponController implements CouponRemote {

    @Autowired
    private CouponService couponService;


    @Override
    public Bizdto<Boolean> insertCoupon(Coupon coupon) {
        boolean result = couponService.insertCoupon(coupon);
        Bizdto<Boolean> bizdto = new Bizdto<>();
        bizdto.setMessage("请求成功");
        bizdto.setCode(StatusCode.OK);
        bizdto.setData(result);
        return bizdto;
    }

    @Override
    public Bizdto<PageResult<Coupon>> getCouponList(Map<String, Object> map) {
        return couponService.getCouponList(map);
    }
}
