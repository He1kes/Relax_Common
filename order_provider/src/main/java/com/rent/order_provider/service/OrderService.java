package com.rent.order_provider.service;

import com.heikes.rent_common.kuo.OrderMoney;
import com.heikes.rent_common.pojo.OrderInfo;

import java.util.List;

public interface OrderService {
    public List<OrderInfo> getOrders(Long userId, String orderStatus);

    public int generateOrder(OrderInfo order);

    public int updateOrderStatus(Long orderId,String orderStatus);

    public OrderInfo getOrderById(Long id);

    public List<OrderInfo> getOrdersBack(Long landId,String orderStatus);

    public int setOrderRemark(Long orderId,String cancel);

    public double getOrderMoney(Integer year,Integer month,Integer day,Long landId,String orderStatus);

    public int getOrderCounts(Long landId,String orderStatus);

    public List<OrderMoney> getOrderMoneyDay(Integer year, Integer month, Integer day, Long landId);

    public List<OrderMoney> getOrderMoneyMonth (Integer year,Integer month,Long landId);
}
