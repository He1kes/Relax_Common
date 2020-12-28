package com.heikes.rent_common.pojo;

import java.io.Serializable;

/**
 * <p>
 * 财务表
 * </p>
 *
 * @author yanxin
 * @since 2020-12-24
 */
public class FinancialInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 房源id,关联房东表
     */
    private Integer landlordId;

    /**
     * 房东收入资金
     */
    private Double landlordIncome;

    /**
     * 0表示未完成，1表示完成
     */
    private Integer financialStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(Integer landlordId) {
        this.landlordId = landlordId;
    }
    public Double getLandlordIncome() {
        return landlordIncome;
    }

    public void setLandlordIncome(Double landlordIncome) {
        this.landlordIncome = landlordIncome;
    }
    public Integer getFinancialStatus() {
        return financialStatus;
    }

    public void setFinancialStatus(Integer financialStatus) {
        this.financialStatus = financialStatus;
    }

    @Override
    public String toString() {
        return "FinancialInfo{" +
            "id=" + id +
            ", landlordId=" + landlordId +
            ", landlordIncome=" + landlordIncome +
            ", financialStatus=" + financialStatus +
        "}";
    }
}
