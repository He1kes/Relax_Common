package com.heikes.rent_common.pojo;

import java.io.Serializable;

/**
 * <p>
 * 利润明细
 * </p>
 *
 * @author yanxin
 * @since 2020-12-24
 */
public class FinancialDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 月份
     */
    private Integer month;

    /**
     * 收入
     */
    private Double incomeDetails;

    /**
     * 这笔支出的明细	
     */
    private String desc;

    /**
     * 关联财务表
     */
    private Integer financialId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }
    public Double getIncomeDetails() {
        return incomeDetails;
    }

    public void setIncomeDetails(Double incomeDetails) {
        this.incomeDetails = incomeDetails;
    }
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    public Integer getFinancialId() {
        return financialId;
    }

    public void setFinancialId(Integer financialId) {
        this.financialId = financialId;
    }

    @Override
    public String toString() {
        return "FinancialDetails{" +
            "id=" + id +
            ", month=" + month +
            ", incomeDetails=" + incomeDetails +
            ", desc=" + desc +
            ", financialId=" + financialId +
        "}";
    }
}
