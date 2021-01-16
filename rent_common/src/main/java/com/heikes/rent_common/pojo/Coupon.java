package com.heikes.rent_common.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

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
public class Coupon implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 优惠券id
     */
    private Long couponId;

    /**
     * 优惠券名称
     */
    private String couponTitle;

    /**
     * 描述
     */
    private String couponDesc;

    /**
     * 数量
     */
    private Integer couponCount;

    /**
     * 每人限领
     */
    private Integer couponSeveral;

    /**
     * 是否有兑换码
     */
    private Integer couponHastoken;

    /**
     * 开始日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date couponStart;

    /**
     * 结束日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date couponEnd;

    /**
     * 优惠券类型
     */
    private Integer couponType;

    /**
     * 使用条件
     */
    private String couponCondition;

    /**
     * 优惠券内容
     */
    private String couponContent;

    /**
     * 全平台：-1，单个商户：商户id
     */
    private Long couponScope;

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }
    public String getCouponTitle() {
        return couponTitle;
    }

    public void setCouponTitle(String couponTitle) {
        this.couponTitle = couponTitle;
    }
    public String getCouponDesc() {
        return couponDesc;
    }

    public void setCouponDesc(String couponDesc) {
        this.couponDesc = couponDesc;
    }
    public Integer getCouponCount() {
        return couponCount;
    }

    public void setCouponCount(Integer couponCount) {
        this.couponCount = couponCount;
    }
    public Integer getCouponSeveral() {
        return couponSeveral;
    }

    public void setCouponSeveral(Integer couponSeveral) {
        this.couponSeveral = couponSeveral;
    }
    public Integer getCouponHastoken() {
        return couponHastoken;
    }

    public void setCouponHastoken(Integer couponHastoken) {
        this.couponHastoken = couponHastoken;
    }
    public Date getCouponStart() {
        return couponStart;
    }

    public void setCouponStart(Date couponStart) {
        this.couponStart = couponStart;
    }
    public Date getCouponEnd() {
        return couponEnd;
    }

    public void setCouponEnd(Date couponEnd) {
        this.couponEnd = couponEnd;
    }
    public Integer getCouponType() {
        return couponType;
    }

    public void setCouponType(Integer couponType) {
        this.couponType = couponType;
    }
    public String getCouponCondition() {
        return couponCondition;
    }

    public void setCouponCondition(String couponCondition) {
        this.couponCondition = couponCondition;
    }
    public String getCouponContent() {
        return couponContent;
    }

    public void setCouponContent(String couponContent) {
        this.couponContent = couponContent;
    }

    public Long getCouponScope() {
        return couponScope;
    }

    public void setCouponScope(Long couponScope) {
        this.couponScope = couponScope;
    }

    @Override
    public String toString() {
        return "Coupon{" +
            "couponId=" + couponId +
            ", couponTitle=" + couponTitle +
            ", couponDesc=" + couponDesc +
            ", couponCount=" + couponCount +
            ", couponSeveral=" + couponSeveral +
            ", couponHastoken=" + couponHastoken +
            ", couponStart=" + couponStart +
            ", couponEnd=" + couponEnd +
            ", couponType=" + couponType +
            ", couponCondition=" + couponCondition +
            ", couponContent=" + couponContent +
            ", couponScope=" + couponScope +
        "}";
    }
}
