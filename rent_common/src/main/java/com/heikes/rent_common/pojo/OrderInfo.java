package com.heikes.rent_common.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 订单信息表
 * </p>
 *
 * @author yanxin
 * @since 2020-12-24
 */
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 关联用户表,用户id
     */
    private Long userId;

    /**
     * 订单状态
     */
    private String orderStatus;

    /**
     * 订单总花费
     */
    private Double orderTotal;

    /**
     * 用户联系方式手机号
     */
    private String userPhone;

    /**
     * 订单号	
     */
    private String orderNumber;

    /**
     * 订单创建时间
     */
    private Date orderTime;

    /**
     * 关联房东表	
     */
    private Long landlordId;

    /**
     * 关联房源表
     */
    private Long houseId;

    /**
     * 支付宝交易号
     */
    private String tradeNo;

    /**
     * 退款请求号
     */
    private String widrqoutRequestNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
    public Long getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(Long landlordId) {
        this.landlordId = landlordId;
    }
    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }
    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
    public String getWidrqoutRequestNo() {
        return widrqoutRequestNo;
    }

    public void setWidrqoutRequestNo(String widrqoutRequestNo) {
        this.widrqoutRequestNo = widrqoutRequestNo;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
            "id=" + id +
            ", userId=" + userId +
            ", orderStatus=" + orderStatus +
            ", orderTotal=" + orderTotal +
            ", userPhone=" + userPhone +
            ", orderNumber=" + orderNumber +
            ", orderTime=" + orderTime +
            ", landlordId=" + landlordId +
            ", houseId=" + houseId +
            ", tradeNo=" + tradeNo +
            ", widrqoutRequestNo=" + widrqoutRequestNo +
        "}";
    }
}
