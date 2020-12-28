package com.heikes.rent_common.pojo;

import java.io.Serializable;

/**
 * <p>
 * 户型表
 * </p>
 *
 * @author yanxin
 * @since 2020-12-24
 */
public class HouseType implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 户型,例如:一室一厅
     */
    private String houseTypeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getHouseTypeName() {
        return houseTypeName;
    }

    public void setHouseTypeName(String houseTypeName) {
        this.houseTypeName = houseTypeName;
    }

    @Override
    public String toString() {
        return "HouseType{" +
            "id=" + id +
            ", houseTypeName=" + houseTypeName +
        "}";
    }
}
