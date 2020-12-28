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
public class CouponToken implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 优惠券id
     */
    private Long couponId;

    /**
     * token码
     */
    private String token;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "CouponToken{" +
            "id=" + id +
            ", couponId=" + couponId +
            ", token=" + token +
        "}";
    }
}
