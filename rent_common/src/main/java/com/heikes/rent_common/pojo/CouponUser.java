package com.heikes.rent_common.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yanxin
 * @since 2020-12-24
 */
public class CouponUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 优惠券id
     */
    private Long couponId;

    /**
     * token码
     */
    private String couponToken;

    /**
     * 发放日期
     */
    private Date grantDate;

    /**
     * 消费日期
     */
    private Date consumeDate;

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
    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }
    public String getCouponToken() {
        return couponToken;
    }

    public void setCouponToken(String couponToken) {
        this.couponToken = couponToken;
    }
    public Date getGrantDate() {
        return grantDate;
    }

    public void setGrantDate(Date grantDate) {
        this.grantDate = grantDate;
    }
    public Date getConsumeDate() {
        return consumeDate;
    }

    public void setConsumeDate(Date consumeDate) {
        this.consumeDate = consumeDate;
    }

    @Override
    public String toString() {
        return "CouponUser{" +
            "id=" + id +
            ", userId=" + userId +
            ", couponId=" + couponId +
            ", couponToken=" + couponToken +
            ", grantDate=" + grantDate +
            ", consumeDate=" + consumeDate +
        "}";
    }
}
