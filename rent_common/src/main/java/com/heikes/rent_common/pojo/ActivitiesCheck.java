package com.heikes.rent_common.pojo;

import java.io.Serializable;

/**
 * <p>
 * 活动审核表
 * </p>
 *
 * @author yanxin
 * @since 2020-12-24
 */
public class ActivitiesCheck implements Serializable {

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
     *
     * 关联优惠表
     */
    private int offId;

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

    public int getOffId() {
        return offId;
    }

    public void setOffId(int offId) {
        this.offId = offId;
    }

    @Override
    public String toString() {
        return "ActivitiesCheck{" +
                "id=" + id +
                ", landlordId=" + landlordId +
                ", houseId=" + houseId +
                ", offId=" + offId +
                '}';
    }
}
