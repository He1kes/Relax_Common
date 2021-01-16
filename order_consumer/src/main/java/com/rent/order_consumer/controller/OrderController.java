package com.rent.order_consumer.controller;

import com.github.pagehelper.PageInfo;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.kuo.OrderMoney;
import com.heikes.rent_common.meiju.OrderStatus;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.OrderInfo;
import com.heikes.rent_common.utils.IdWorker;
import com.heikes.rent_common.vo.ResultVo;
import com.rent.order_consumer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /*通过token拿userId*/
    @RequestMapping("/front/private/getUserIdByToken")
    public ResultVo<String> getUserIdByToken(HttpServletRequest request){
        String token = request.getHeader("token");
        ResultVo<String> resultVo = new ResultVo<>();
        String tokenTemp = token == null ? "" : token;
        String userId = (String) stringRedisTemplate.opsForHash().get(tokenTemp, "userId");
        if(userId != null){
            resultVo.setFlag(true);
            resultVo.setData(userId);
        }else {
            resultVo.setFlag(false);
            resultVo.setMessage("获取userId出错！order-con-c");
        }
        return resultVo;
    }

    /*根据用户id、订单状态（皆非必须），分页显示订单*/
/*    @RequestMapping("/front/private/getOrdersByUserIdOrderStatus")
    public ResultVo<PageInfo<OrderInfo>> getOrdersByUserIdOrderStatus(
            @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize,
            @RequestParam(value = "userId",required = false) Long userId, @RequestParam(value = "orderStatus",required = false) String orderStatus)
    {
        Bizdto<PageInfo<OrderInfo>> bizdto = orderService.getOrdersByUserIdOrderStatus(pageNo, pageSize, userId, orderStatus);
        ResultVo<PageInfo<OrderInfo>> resultVo = new ResultVo<>();
        if(bizdto.getCode() == StatusCode.OK){
            resultVo.setFlag(true);
            resultVo.setData(bizdto.getData());
        }else {
            resultVo.setFlag(false);
            resultVo.setMessage("getOrdersByUserIdOrderStatus获取数据出现错误ord-cons-c！");
        }
        return resultVo;
    }*/


    @RequestMapping({"/front/private/getOrdersByUserIdOrderStatus","/getOrdersByUserIdOrderStatus"})
    public Map<String,Object> getOrdersByUserIdOrderStatus(
            @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize,
            @RequestParam(value = "userId",required = false) Long userId, @RequestParam(value = "orderStatus",required = false) String orderStatus)
    {
        Bizdto<PageInfo<OrderInfo>> bizdto = orderService.getOrdersByUserIdOrderStatus(pageNo, pageSize, userId, orderStatus);
        Map<String,Object> dataMap = new HashMap<>();
        if(bizdto.getCode() == StatusCode.OK){
            PageInfo<OrderInfo> pageInfo = bizdto.getData();
            List<OrderInfo> orderInfoList = pageInfo.getList();
            List<String> houseIdList = new ArrayList<>();
            List<String> landIdList = new ArrayList<>();
            for(OrderInfo order:orderInfoList){
                houseIdList.add(order.getHouseId().toString());
                landIdList.add(order.getLandlordId().toString());
            }
            dataMap.put("orders",pageInfo);
            dataMap.put("houseIds",houseIdList);
            dataMap.put("landIds",landIdList);
        }else {
            dataMap.put("message","getOrdersByUserIdOrderStatus获取数据出现错误ord-cons-c！");
        }
        return dataMap;
    }

    /*生成订单*/
    @RequestMapping("/front/private/generateOrder")
    public ResultVo<Integer> generateOrder(@RequestBody OrderInfo order){
        //生成订单号
        IdWorker idWorker = new IdWorker();
        String orderNumber = Long.toString(idWorker.nextId());
        order.setOrderNumber(orderNumber);
        //设置订单创建时间、初始状态（待房东确认）
        order.setOrderStatus(OrderStatus.WAIT_CHECK.getOrderStautsName());
        order.setOrderTime(new Date());
        Bizdto<Integer> bizdto = orderService.generateOrder(order);
        ResultVo<Integer> resultVo = new ResultVo<>();
        if(bizdto.getCode() == StatusCode.OK){
            resultVo.setFlag(true);
            resultVo.setData(bizdto.getData());
        }else {
            resultVo.setFlag(false);
            resultVo.setMessage("generateOrder获取数据出现错误ord-cons-c！");
        }
        return resultVo;
    }

    /*修改订单状态*/
    @RequestMapping("/front/private/updateOrderStatus")
    public ResultVo<Integer> updateOrderStatus(@RequestParam("orderId") Long orderId,@RequestParam("orderStatus") String OrderStatus){
        Bizdto<Integer> bizdto = orderService.updateOrderStatus(orderId, OrderStatus);
        ResultVo<Integer> resultVo = new ResultVo<>();
        if(bizdto.getCode() == StatusCode.OK){
            resultVo.setFlag(true);
            resultVo.setData(bizdto.getData());
        }else {
            resultVo.setFlag(false);
            resultVo.setMessage("updateOrderStatus获取数据出现错误ord-cons-c！");
        }
        return resultVo;
    }

    /*根据id查询订单*/
    @RequestMapping("/front/private/getOrderById")
    public ResultVo<OrderInfo> getOrderById(@RequestParam("id") Long id){
        Bizdto<OrderInfo> bizdto = orderService.getOrderById(id);
        ResultVo<OrderInfo> resultVo = new ResultVo<>();
        if(bizdto.getCode() == StatusCode.OK){
            resultVo.setFlag(true);
            resultVo.setData(bizdto.getData());
        }else {
            resultVo.setFlag(false);
            resultVo.setMessage("getOrderById获取数据出现错误ord-cons-c！");
        }
        return resultVo;
    }


    /*存储取消订单原因*/
    @RequestMapping(value = {"/front/private/setOrderRemark","/setOrderRemark"})
    public ResultVo<Integer> setOrderRemark(@RequestParam("orderId") Long orderId, @RequestParam("cancel") String cancel){
        Bizdto<Integer> bizdto = orderService.setOrderRemark(orderId, cancel);
        Bizdto<Integer> bizdto2 = orderService.updateOrderStatus(orderId,OrderStatus.WAIT_REFUND.getOrderStautsName());
        ResultVo<Integer> resultVo = new ResultVo<>();
        if(bizdto.getCode() == StatusCode.OK){
            resultVo.setFlag(true);
            resultVo.setData(bizdto.getData());
        }else {
            resultVo.setFlag(false);
            resultVo.setMessage("setOrderRemark获取数据出现错误ord-cons-c！");
        }
        return resultVo;
    }

    /*后台查询（带取消订单原因）*/
    @RequestMapping(value = {"/back/getOrdersBack","/getOrdersBack"})
    public Map<String,Object> getOrdersBack(
            @RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize,
            @RequestParam(value = "landId",required = false) Long landId, @RequestParam(value = "orderStatus",required = false) String orderStatus){
        Bizdto<PageInfo<OrderInfo>> bizdto = orderService.getOrdersBack(pageNo, pageSize, landId, orderStatus);
        Map<String,Object> dataMap = new HashMap<>();
        if(bizdto.getCode() == StatusCode.OK){
            PageInfo<OrderInfo> pageInfo = bizdto.getData();
            List<OrderInfo> orderInfoList = pageInfo.getList();
            List<String> houseIdList = new ArrayList<>();
            List<String> userIdList = new ArrayList<>();
            List<String> landIdList = new ArrayList<>();
            for(OrderInfo order:orderInfoList){
                houseIdList.add(order.getHouseId().toString());
                userIdList.add(order.getUserId().toString());
                landIdList.add(order.getLandlordId().toString());
            }
            dataMap.put("orders",pageInfo);
            dataMap.put("houseIds",houseIdList);
            dataMap.put("userIds",userIdList);
            dataMap.put("landIds",landIdList);
        }else {
            dataMap.put("message","getOrdersBack获取数据出现错误ord-cons-c！");
        }
        return dataMap;
    }

    /*统计订单金额*/
    @RequestMapping("/back/getOrderMoney")
    public Double getOrderMoney(
            @RequestParam(value = "year",required = false) Integer year,
            @RequestParam(value = "month",required = false) Integer month,
            @RequestParam(value = "day",required = false) Integer day,
            @RequestParam(value = "landId",required = false) Long landId,
            @RequestParam(value = "orderStatus",required = false) String orderStatus){
        Bizdto<Double> bizdto = orderService.getOrderMoney(year, month, day, landId, orderStatus);
        if(bizdto.getData() == null){
            return 0D;
        }else{
            return  bizdto.getData();
        }
    }

    /*统计订单总单数*/
    @RequestMapping("/back/getOrderCounts")
    public Integer getOrderCounts(
            @RequestParam(value = "landId",required = false) Long landId,
            @RequestParam(value = "orderStatus",required = false) String orderStatus){
        Bizdto<Integer> bizdto = orderService.getOrderCounts(landId, orderStatus);
        return bizdto.getData();
    }

    /*统计订单金额（每天）*/
    @RequestMapping("/back/getOrderMoneyDay")
    public Double[] getOrderMoneyDay(
            @RequestParam("year") Integer year,@RequestParam("month") Integer month,@RequestParam("day") Integer day,
            @RequestParam(value = "landId",required = false) Long landId){
        Double[] dataMoney = new Double[day];
        for(int i=0;i<day;i++){
            dataMoney[i] = 0D;
        }
        Bizdto<List<OrderMoney>> bizdto = orderService.getOrderMoneyDay(year, month, day, landId);
        List<OrderMoney> moneyList = bizdto.getData();
        for(OrderMoney orderMoney: moneyList){
            dataMoney[orderMoney.getRiqi()-1] = orderMoney.getMoney();
        }
        return dataMoney;
    }

    /*统计订单金额（每月）*/
    @RequestMapping("/back/getOrderMoneyMonth")
    public Double[] getOrderMoneyMonth(
            @RequestParam("year") Integer year,@RequestParam("month") Integer month,
            @RequestParam(value = "landId",required = false) Long landId){
        Double[] dataMoney = new Double[month];
        for(int i=0;i<month;i++){
            dataMoney[i] = 0D;
        }
        Bizdto<List<OrderMoney>> bizdto = orderService.getOrderMoneyMonth(year, month, landId);
        List<OrderMoney> moneyList = bizdto.getData();
        for(OrderMoney orderMoney: moneyList){
            dataMoney[orderMoney.getRiqi()-1] = orderMoney.getMoney();
        }
        return dataMoney;
    }
}
