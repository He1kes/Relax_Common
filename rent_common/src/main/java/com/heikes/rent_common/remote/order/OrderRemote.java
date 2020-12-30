package com.heikes.rent_common.remote.order;

import com.github.pagehelper.PageInfo;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.OrderInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


public interface OrderRemote {

    /*根据用户id、订单状态（皆非必须），分页显示订单*/
    @RequestMapping("/getOrdersByUserIdOrderStatus")
    public Bizdto<PageInfo<OrderInfo>> getOrdersByUserIdOrderStatus(
            @RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize,
            @RequestParam("userId") Long userId,@RequestParam("orderStatus") String orderStatus);

    /*生成订单*/
    @RequestMapping("/generateOrder")
    public Bizdto<Integer> generateOrder(@RequestBody OrderInfo order);

    /*修改订单状态*/
    @RequestMapping("/updateOrderStatus")
    public Bizdto<Integer> updateOrderStatus(@RequestParam("orderId") Long orderId,@RequestParam("orderStatus") String OrderStatus);

    /*根据id查询订单*/
    @RequestMapping("/getOrderById")
    public Bizdto<OrderInfo> getOrderById(Long id);
}
