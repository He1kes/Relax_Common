package com.heikes.rent_common.pojo;

import java.io.Serializable;

/**
 * <p>
 * 心愿表
 * </p>
 *
 * @author yanxin
 * @since 2020-12-24
 */
public class HouseCollect implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 关联房源表
     */
    private Integer houseId;

    /**
     * 关联用户表
     */
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "HouseCollect{" +
                "id=" + id +
                ", houseId=" + houseId +
                ", userId=" + userId +
                '}';
    }
}
