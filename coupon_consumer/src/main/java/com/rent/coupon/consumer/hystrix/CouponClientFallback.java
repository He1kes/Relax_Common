package com.rent.coupon.consumer.hystrix;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.Coupon;
import com.heikes.rent_common.vo.PageResult;
import com.rent.coupon.consumer.client.CouponClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/16
 * @Time:10:01
 */
@Component
public class CouponClientFallback implements FallbackFactory<CouponClient> {
    @Override
    public CouponClient create(Throwable cause) {
        return new CouponClient() {
            @Override
            public Bizdto<Boolean> insertCoupon(Coupon coupon) {
                Bizdto<Boolean> bizdto = new Bizdto<>();
                bizdto.setData(false);
                bizdto.setMessage("请求失败");
                bizdto.setCode(StatusCode.REMOTEERROR);
                return bizdto;
            }

            @Override
            public Bizdto<PageResult<Coupon>> getCouponList(Map<String, Object> map) {
                Bizdto<PageResult<Coupon>> bizdto = new Bizdto<>();
                bizdto.setData(null);
                bizdto.setMessage("请求失败");
                bizdto.setCode(StatusCode.REMOTEERROR);
                return bizdto;
            }
        };
    }
}
