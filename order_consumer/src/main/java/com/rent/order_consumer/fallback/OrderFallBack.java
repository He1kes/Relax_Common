package com.rent.order_consumer.fallback;

import com.github.pagehelper.PageInfo;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.kuo.OrderMoney;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.OrderInfo;
import com.rent.order_consumer.client.OrderClient;
import feign.hystrix.FallbackFactory;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderFallBack implements FallbackFactory<OrderClient> {
    @Override
    public OrderClient create(Throwable throwable) {
        return new OrderClient() {
            @Override
            public Bizdto<PageInfo<OrderInfo>> getOrdersByUserIdOrderStatus(Integer pageNo, Integer pageSize, Long userId, String orderStatus) {
                Bizdto<PageInfo<OrderInfo>> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage("熔断，获取订单列表时发生错误。");
                return bizdto;
            }

            @Override
            public Bizdto<Integer> generateOrder(OrderInfo order) {
                Bizdto<Integer> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage("熔断，生成订单发生错误。");
                return bizdto;
            }

            @Override
            public Bizdto<Integer> updateOrderStatus(Long orderId, String OrderStatus) {
                Bizdto<Integer> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage("熔断，修改订单状态时发生错误。");
                return bizdto;
            }

            @Override
            public Bizdto<OrderInfo> getOrderById(Long id) {
                Bizdto<OrderInfo> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage("熔断，获取单个订单时发生错误。");
                return bizdto;
            }

            @Override
            public Bizdto<PageInfo<OrderInfo>> getOrdersBack(Integer pageNo, Integer pageSize, Long landId, String orderStatus) {
                Bizdto<PageInfo<OrderInfo>> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage("熔断，后台获取订单列表时发生错误。");
                return bizdto;
            }

            @Override
            public Bizdto<Integer> setOrderRemark(Long orderId, String cancel) {
                Bizdto<Integer> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage("熔断，存储取消订单原因时发生错误。");
                return bizdto;
            }

            @Override
            public Bizdto<Double> getOrderMoney(Integer year, Integer month, Integer day, Long landId, String orderStatus) {
                Bizdto<Double> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage("熔断，获取订单总额时发生错误。");
                return bizdto;
            }

            @Override
            public Bizdto<Integer> getOrderCounts(Long landId, String orderStatus) {
                Bizdto<Integer> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage("熔断，获取订单总单数时发生错误。");
                return bizdto;
            }

            @Override
            public Bizdto<List<OrderMoney>> getOrderMoneyDay(Integer year, Integer month, Integer day, Long landId) {
                Bizdto<List<OrderMoney>> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage("熔断，获取订单每天总额时发生错误。");
                return bizdto;
            }

            @Override
            public Bizdto<List<OrderMoney>> getOrderMoneyMonth(Integer year, Integer month, Long landId) {
                Bizdto<List<OrderMoney>> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage("熔断，获取订单每月总额时发生错误。");
                return bizdto;
            }
        };
    }
}
