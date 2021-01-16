package com.rent.order_provider.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.kuo.OrderMoney;
import com.heikes.rent_common.meiju.OrderStatus;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.OrderInfo;
import com.heikes.rent_common.remote.order.OrderRemote;
import com.rent.order_provider.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController implements OrderRemote {
    @Autowired
    private OrderService orderService;

    /*根据用户id、订单状态（皆非必须），分页显示订单*/
    @Override
    public Bizdto<PageInfo<OrderInfo>> getOrdersByUserIdOrderStatus(Integer pageNo, Integer pageSize, Long userId, String orderStatus) {
        PageHelper.startPage(pageNo,pageSize);
        List<OrderInfo> orderInfos = orderService.getOrders(userId, orderStatus);
        PageInfo<OrderInfo> pageInfo = new PageInfo<>(orderInfos,5);
        Bizdto<PageInfo<OrderInfo>> bizdto = new Bizdto<PageInfo<OrderInfo>>();
        bizdto.setCode(StatusCode.OK);
        bizdto.setMessage("getOrdersByUserIdOrderStatus方法执行成功。");
        bizdto.setData(pageInfo);
        return bizdto;
    }

    /*生成订单*/
    @Override
    public Bizdto<Integer> generateOrder(OrderInfo order) {
        int count = orderService.generateOrder(order);
        Bizdto<Integer> bizdto = new Bizdto<>();
        if(count > 0){
            bizdto.setCode(StatusCode.OK);
            bizdto.setMessage("generateOrder方法执行成功。");
            bizdto.setData(count);
        }else {
            bizdto.setCode(StatusCode.ERROR);
            bizdto.setMessage("generateOrder方法执行失败。");
            bizdto.setData(count);
        }
        return bizdto;
    }

    /*修改订单状态*/
    @Override
    public Bizdto<Integer> updateOrderStatus(Long orderId, String OrderStatus) {
        int count = orderService.updateOrderStatus(orderId, OrderStatus);
        Bizdto<Integer> bizdto = new Bizdto<>();
        if(count > 0){
            bizdto.setCode(StatusCode.OK);
            bizdto.setMessage("updateOrderStatus方法执行成功。");
            bizdto.setData(count);
        }else {
            bizdto.setCode(StatusCode.ERROR);
            bizdto.setMessage("updateOrderStatus方法执行失败。");
            bizdto.setData(count);
        }
        return bizdto;
    }

    /*根据id查询订单*/
    @Override
    public Bizdto<OrderInfo> getOrderById(Long id) {
        OrderInfo orderInfo = orderService.getOrderById(id);
        Bizdto<OrderInfo> bizdto = new Bizdto<>();
        bizdto.setCode(StatusCode.OK);
        bizdto.setMessage("getOrderById方法执行成功。");
        bizdto.setData(orderInfo);
        return bizdto;
    }

    /*后台查询（带取消订单原因）*/
    @Override
    public Bizdto<PageInfo<OrderInfo>> getOrdersBack(Integer pageNo, Integer pageSize, Long landId, String orderStatus) {
        PageHelper.startPage(pageNo,pageSize);
        List<OrderInfo> orderInfos = orderService.getOrdersBack(landId, orderStatus);
        PageInfo<OrderInfo> pageInfo = new PageInfo<>(orderInfos,5);
        Bizdto<PageInfo<OrderInfo>> bizdto = new Bizdto<PageInfo<OrderInfo>>();
        bizdto.setCode(StatusCode.OK);
        bizdto.setMessage("getOrdersBack方法执行成功。");
        bizdto.setData(pageInfo);
        return bizdto;
    }

    /*存储取消订单原因*/
    @Override
    public Bizdto<Integer> setOrderRemark(Long orderId, String cancel) {
        int count = orderService.setOrderRemark(orderId, cancel);
        Bizdto<Integer> bizdto = new Bizdto<>();
        if(count > 0){
            bizdto.setCode(StatusCode.OK);
            bizdto.setMessage("setOrderRemark方法执行成功。");
            bizdto.setData(count);
        }else {
            bizdto.setCode(StatusCode.ERROR);
            bizdto.setMessage("setOrderRemark方法执行失败。");
            bizdto.setData(count);
        }
        return bizdto;
    }

    /*统计订单金额*/
    @Override
    public Bizdto<Double> getOrderMoney(Integer year, Integer month, Integer day, Long landId, String orderStatus) {
        double money = orderService.getOrderMoney(year, month, day, landId, orderStatus);
        Bizdto<Double> bizdto = new Bizdto<>();
        bizdto.setCode(StatusCode.OK);
        bizdto.setMessage("getOrderMoney方法执行成功。");
        bizdto.setData(money);
        return bizdto;
    }

    /*统计订单总单数*/
    @Override
    public Bizdto<Integer> getOrderCounts(Long landId, String orderStatus) {
        Bizdto<Integer> bizdto = new Bizdto<>();
        int count = orderService.getOrderCounts(landId, orderStatus);
        bizdto.setCode(StatusCode.OK);
        bizdto.setData(count);
        bizdto.setMessage("getOrderCounts方法执行成功。");
        return bizdto;
    }

    /*统计订单金额（每天）*/
    @Override
    public Bizdto<List<OrderMoney>> getOrderMoneyDay(Integer year, Integer month, Integer day, Long landId) {
        Bizdto<List<OrderMoney>> bizdto = new Bizdto<>();
        List<OrderMoney> moneyList = orderService.getOrderMoneyDay(year, month, day, landId);
        bizdto.setCode(StatusCode.OK);
        bizdto.setMessage("getOrderMoneyDay方法执行成功。");
        bizdto.setData(moneyList);
        return bizdto;
    }

    /*统计订单金额（每月）*/
    @Override
    public Bizdto<List<OrderMoney>> getOrderMoneyMonth(Integer year, Integer month, Long landId) {
        Bizdto<List<OrderMoney>> bizdto = new Bizdto<>();
        List<OrderMoney> moneyList = orderService.getOrderMoneyMonth(year, month, landId);
        bizdto.setCode(StatusCode.OK);
        bizdto.setMessage("getOrderMoneyMonth方法执行成功。");
        bizdto.setData(moneyList);
        return bizdto;
    }
}
