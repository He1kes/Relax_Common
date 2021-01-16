package com.rent.order_consumer.service.impl;

import com.github.pagehelper.PageInfo;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.kuo.OrderMoney;
import com.heikes.rent_common.pojo.OrderInfo;
import com.heikes.rent_common.vo.ResultVo;
import com.rent.order_consumer.client.OrderClient;
import com.rent.order_consumer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderClient orderClient;

    @Override
    public Bizdto<PageInfo<OrderInfo>> getOrdersByUserIdOrderStatus(Integer pageNo, Integer pageSize, Long userId, String orderStatus) {
        Bizdto<PageInfo<OrderInfo>> bizdto = orderClient.getOrdersByUserIdOrderStatus(pageNo, pageSize, userId, orderStatus);
        return bizdto;
    }

    @Override
    public Bizdto<Integer> generateOrder(OrderInfo order) {
        Bizdto<Integer> bizdto = orderClient.generateOrder(order);
        return bizdto;
    }

    @Override
    public Bizdto<Integer> updateOrderStatus(Long orderId, String OrderStatus) {
        Bizdto<Integer> bizdto = orderClient.updateOrderStatus(orderId, OrderStatus);
        return bizdto;
    }

    @Override
    public Bizdto<OrderInfo> getOrderById(Long id) {
        Bizdto<OrderInfo> bizdto = orderClient.getOrderById(id);
        return bizdto;
    }

    @Override
    public Bizdto<PageInfo<OrderInfo>> getOrdersBack(Integer pageNo, Integer pageSize, Long landId, String orderStatus) {
        Bizdto<PageInfo<OrderInfo>> bizdto = orderClient.getOrdersBack(pageNo, pageSize, landId, orderStatus);
        return bizdto;
    }

    @Override
    public Bizdto<Integer> setOrderRemark(Long orderId, String cancel) {
        Bizdto<Integer> bizdto = orderClient.setOrderRemark(orderId, cancel);
        return bizdto;
    }

    @Override
    public Bizdto<Double> getOrderMoney(Integer year, Integer month, Integer day, Long landId, String orderStatus) {
        Bizdto<Double> bizdto = orderClient.getOrderMoney(year, month, day, landId, orderStatus);
        return bizdto;
    }

    @Override
    public Bizdto<Integer> getOrderCounts(Long landId, String orderStatus) {
        Bizdto<Integer> bizdto = orderClient.getOrderCounts(landId, orderStatus);
        return bizdto;
    }

    @Override
    public Bizdto<List<OrderMoney>> getOrderMoneyDay(Integer year, Integer month, Integer day, Long landId) {
        Bizdto<List<OrderMoney>> bizdto = orderClient.getOrderMoneyDay(year, month, day, landId);
        return  bizdto;
    }

    @Override
    public Bizdto<List<OrderMoney>> getOrderMoneyMonth(Integer year, Integer month, Long landId) {
        Bizdto<List<OrderMoney>> bizdto = orderClient.getOrderMoneyMonth(year, month, landId);
        return bizdto;
    }
}
