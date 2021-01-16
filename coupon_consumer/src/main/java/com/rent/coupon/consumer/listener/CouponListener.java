package com.rent.coupon.consumer.listener;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.Coupon;
import com.heikes.rent_common.utils.IdWorker;
import com.rent.coupon.consumer.service.CouponService;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/16
 * @Time:10:25
 */
@Component
public class CouponListener {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private CouponService couponService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    @RabbitListener(queues = {"couponQueue"})
    public void doAddCoupon(Coupon coupon) {
        coupon.setCouponId(idWorker.nextId());
        Bizdto<Boolean> bizdto = couponService.addCoupon(coupon);
        if (bizdto.getData() == true) {
            //设置发行张数
            stringRedisTemplate.opsForList()
                    .leftPushAll("coupon:count:" + coupon.getCouponId(),
                            getCouponCount(coupon.getCouponCount()));
            //设置每个人能获取的张数
            stringRedisTemplate.opsForValue().set("coupon:count:" + coupon.getCouponId()
                                                   + ":" + "everyone:get", coupon.getCouponSeveral().toString());
            //绑定消息队列与交换机
            amqpAdmin.declareBinding(
                    new Binding("getCouponQueue",
                            Binding.DestinationType.QUEUE,
                            "getCouponExchange",
                            "routingKey" + coupon.getCouponId().toString(),
                            null));
        }

    }

    /**
     * @param count
     * @return
     * 根据优惠券的数量生成相应个数的标记
     */
    private static List getCouponCount(int count) {
        List counts = new ArrayList();
        for (int i = 0; i < count; i++) {
            counts.add(1);
        }
        return counts;
    }
}
