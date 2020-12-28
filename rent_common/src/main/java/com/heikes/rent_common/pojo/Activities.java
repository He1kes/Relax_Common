package com.heikes.rent_common.pojo;

import java.io.Serializable;

/**
 * <p>
 * 活动表
 * </p>
 *
 * @author yanxin
 * @since 2020-12-24
 */
public class Activities implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 关联房东表
     */
    private Integer landlordId;

    /**
     * 关联房源表	
     */
    private Integer houseId;

    /**
     * 关联优惠表
     */
    private Integer offId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(Integer landlordId) {
        this.landlordId = landlordId;
    }
    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }
    public Integer getOffId() {
        return offId;
    }

    public void setOffId(Integer offId) {
        this.offId = offId;
    }

    @Override
    public String toString() {
        return "Activities{" +
            "id=" + id +
            ", landlordId=" + landlordId +
            ", houseId=" + houseId +
            ", offId=" + offId +
        "}";
    }
}
