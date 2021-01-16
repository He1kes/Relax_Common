package com.rent.order_consumer.service;

import com.github.pagehelper.PageInfo;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.kuo.OrderMoney;
import com.heikes.rent_common.pojo.OrderInfo;
import com.heikes.rent_common.vo.ResultVo;

import java.util.List;

public interface OrderService {

    /*根据用户id、订单状态（皆非必须），分页显示订单*/
    public Bizdto<PageInfo<OrderInfo>> getOrdersByUserIdOrderStatus(
            Integer pageNo,Integer pageSize, Long userId,String orderStatus);

    /*生成订单*/
    public Bizdto<Integer> generateOrder(OrderInfo order);

    /*修改订单状态*/
    public Bizdto<Integer> updateOrderStatus(Long orderId,String OrderStatus);

    /*根据id查询订单*/
    public Bizdto<OrderInfo> getOrderById(Long id);

    /*后台查询（带取消订单原因）*/
    public Bizdto<PageInfo<OrderInfo>> getOrdersBack(
            Integer pageNo,Integer pageSize, Long landId,String orderStatus);

    /*存储取消订单原因*/
    public Bizdto<Integer> setOrderRemark(Long orderId,String cancel);

    /*统计订单金额*/
    public Bizdto<Double> getOrderMoney(Integer year,Integer month,Integer day,Long landId,String orderStatus);

    /*统计订单总单数*/
    public Bizdto<Integer> getOrderCounts(Long landId,String orderStatus);

    /*统计订单金额（每天）*/
    public Bizdto<List<OrderMoney>> getOrderMoneyDay(Integer year, Integer month, Integer day, Long landId);

    /*统计订单金额（每月）*/
    public Bizdto<List<OrderMoney>> getOrderMoneyMonth (Integer year,Integer month,Long landId);
}
