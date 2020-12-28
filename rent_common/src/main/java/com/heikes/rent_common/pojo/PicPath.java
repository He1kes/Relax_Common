package com.heikes.rent_common.pojo;

import java.io.Serializable;

/**
 * <p>
 * 房源内部图片表
 * </p>
 *
 * @author yanxin
 * @since 2020-12-24
 */
public class PicPath implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 房源图片存储地址
     */
    private String path;

    /**
     * 关联房源表
     */
    private Integer houseId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    @Override
    public String toString() {
        return "PicPath{" +
            "id=" + id +
            ", path=" + path +
            ", houseId=" + houseId +
        "}";
    }
}
