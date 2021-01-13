package com.heikes.rent_common.meiju;

//订单状态枚举类
public enum OrderStatus {
    //枚举常量列表
    WAIT_PAY("待支付"),CANCEL_ONE("已取消（未付款）"),WAIT_CHECK("待房东确认"),
    CANCEL_TWO("已取消（房东拒绝）"), WAIT_STAY("待入住"),WAIT_REFUND("退款中"),
    REFUND_FAIL("退款失败"),CANCEL_THREE("已取消（已退款）"),HAS_SUCCESS("已消费"),
    HAS_CANCEL("已取消");

    //其他成员、方法
    private String orderStautsName;

    //构造方法，默认private
    private OrderStatus(String ordStatusName){
        this.orderStautsName = ordStatusName;
    }

    //get、set方法
    public String getOrderStautsName() {
        return orderStautsName;
    }

    public void setOrderStautsName(String orderStautsName) {
        this.orderStautsName = orderStautsName;
    }

    //注：controller中使用
    //System.out.println(OrderStatus.WAIT_PAY.getOrderStautsName());
    //输出结果：待支付
}
