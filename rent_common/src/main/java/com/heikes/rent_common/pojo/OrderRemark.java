package com.heikes.rent_common.pojo;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yanxin
 * @since 2020-12-24
 */
public class OrderRemark implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 用户取消订单原因
     */
    private String cancel;

    /**
     * 平台拒绝退款原因
     */
    private String refuse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getCancel() {
        return cancel;
    }

    public void setCancel(String cancel) {
        this.cancel = cancel;
    }
    public String getRefuse() {
        return refuse;
    }

    public void setRefuse(String refuse) {
        this.refuse = refuse;
    }

    @Override
    public String toString() {
        return "OrderRemark{" +
            "id=" + id +
            ", orderId=" + orderId +
            ", cancel=" + cancel +
            ", refuse=" + refuse +
        "}";
    }
}
