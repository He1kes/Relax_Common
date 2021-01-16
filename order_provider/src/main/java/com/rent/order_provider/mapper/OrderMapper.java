package com.rent.order_provider.mapper;

import com.heikes.rent_common.kuo.OrderMoney;
import com.heikes.rent_common.pojo.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {

    /*根据用户Id、订单状态获取订单列表*/
    public List<OrderInfo> getOrders(Long userId,String orderStatus);

    /*生成订单*/
    public int generateOrder(OrderInfo order);

    /*更新订单状态*/
    public int updateOrderStatus(Long orderId,String orderStatus);

    /*根据id查询订单*/
    public OrderInfo getOrderById(Long id);

    /*后台查询（带取消订单原因）*/
    public List<OrderInfo> getOrdersBack(Long landId,String orderStatus);

    /*存储取消订单原因*/
    public int setOrderRemark(Long orderId,String cancel);

    /*统计订单金额*/
    public double getOrderMoney(Integer year,Integer month,Integer day,Long landId,String orderStatus);

    /*统计订单总单数*/
    public int getOrderCounts(Long landId,String orderStatus);

    /*统计订单金额（每天）*/
    public List<OrderMoney> getOrderMoneyDay(Integer year,Integer month,Integer day,Long landId);

    /*统计订单金额（每月）*/
    public List<OrderMoney> getOrderMoneyMonth (Integer year,Integer month,Long landId);
}
