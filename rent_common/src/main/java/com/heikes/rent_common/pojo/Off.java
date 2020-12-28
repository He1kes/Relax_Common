package com.heikes.rent_common.pojo;

import java.io.Serializable;

/**
 * <p>
 * 优惠表
 * </p>
 *
 * @author yanxin
 * @since 2020-12-24
 */
public class Off implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 优惠表述	
     */
    private String offDetails;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getOffDetails() {
        return offDetails;
    }

    public void setOffDetails(String offDetails) {
        this.offDetails = offDetails;
    }

    @Override
    public String toString() {
        return "Off{" +
            "id=" + id +
            ", offDetails=" + offDetails +
        "}";
    }
}
