package com.rent.coupon.consumer.controller;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.Coupon;
import com.heikes.rent_common.vo.PageResult;
import com.heikes.rent_common.vo.ResultVo;
import com.rent.coupon.consumer.service.CouponService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/16
 * @Time:9:29
 */
@RestController
@RequestMapping(value = "/coupon")
public class CouponController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private CouponService couponService;

    @PostMapping(value = "/back/addCoupon")
    public ResultVo<Boolean> addCoupon(Coupon coupon) {
        rabbitTemplate.convertAndSend("couponExchange", "couponRouting", coupon);
        return new ResultVo<Boolean>(true, StatusCode.OK, "请求成功", true);
    }

    @PostMapping(value = "/back/getCouponList")
    public ResultVo<PageResult<Coupon>> getCouponList(Integer pageNum,
                                                      Integer pageSize,
                                                      String couponCondition,
                                                      String couponContent,
                                                      Integer couponType) {

        Bizdto<PageResult<Coupon>> bizdto = couponService.getCouponList(pageNum,
                                                                        pageSize,
                                                                        couponCondition,
                                                                        couponContent,
                                                                        couponType);
        return new ResultVo<>(true, bizdto.getCode(), bizdto.getMessage(), bizdto.getData());
    }
}
