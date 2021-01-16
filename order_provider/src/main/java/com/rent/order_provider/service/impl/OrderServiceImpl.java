package com.rent.order_provider.service.impl;

import com.heikes.rent_common.kuo.OrderMoney;
import com.heikes.rent_common.pojo.OrderInfo;
import com.rent.order_provider.mapper.OrderMapper;
import com.rent.order_provider.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<OrderInfo> getOrders(Long userId, String orderStatus) {
        return orderMapper.getOrders(userId, orderStatus);
    }

    @Override
    public int generateOrder(OrderInfo order) {
        return orderMapper.generateOrder(order);
    }

    @Override
    public int updateOrderStatus(Long orderId, String orderStatus) {
        return orderMapper.updateOrderStatus(orderId, orderStatus);
    }

    @Override
    public OrderInfo getOrderById(Long id) {
        return orderMapper.getOrderById(id);
    }

    @Override
    public List<OrderInfo> getOrdersBack(Long landId, String orderStatus) {
        return orderMapper.getOrdersBack(landId, orderStatus);
    }

    @Override
    public int setOrderRemark(Long orderId, String cancel) {
        return orderMapper.setOrderRemark(orderId, cancel);
    }

    @Override
    public double getOrderMoney(Integer year, Integer month, Integer day, Long landId, String orderStatus) {
        return orderMapper.getOrderMoney(year, month, day, landId, orderStatus);
    }

    @Override
    public int getOrderCounts(Long landId, String orderStatus) {
        return orderMapper.getOrderCounts(landId, orderStatus);
    }

    @Override
    public List<OrderMoney> getOrderMoneyDay(Integer year, Integer month, Integer day, Long landId) {
        return orderMapper.getOrderMoneyDay(year, month, day, landId);
    }

    @Override
    public List<OrderMoney> getOrderMoneyMonth(Integer year, Integer month, Long landId) {
        return orderMapper.getOrderMoneyMonth(year, month, landId);
    }
}
