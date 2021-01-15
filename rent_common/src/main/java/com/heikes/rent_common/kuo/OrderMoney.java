package com.heikes.rent_common.kuo;

import java.io.Serializable;

public class OrderMoney implements Serializable {
    private static final long serialVersionUID = 1L;

    //x轴数据
    private Integer riqi;
    //y轴数据
    private Double money;

    public Integer getRiqi() {
        return riqi;
    }

    public void setRiqi(Integer riqi) {
        this.riqi = riqi;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
