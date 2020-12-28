package com.heikes.rent_common.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 房源预定表
 * </p>
 *
 * @author yanxin
 * @since 2020-12-24
 */
public class AvailabilityStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 开始日期
     */
    private Date startDate;

    /**
     * 结束日期
     */
    private Date stopDate;

    /**
     * 关联房源表房屋信息id
     */
    private Integer houseId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getStopDate() {
        return stopDate;
    }

    public void setStopDate(Date stopDate) {
        this.stopDate = stopDate;
    }
    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    @Override
    public String toString() {
        return "AvailabilityStatus{" +
            "id=" + id +
            ", startDate=" + startDate +
            ", stopDate=" + stopDate +
            ", houseId=" + houseId +
        "}";
    }
}
