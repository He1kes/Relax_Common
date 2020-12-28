package com.heikes.rent_common.pojo;

import java.io.Serializable;

/**
 * <p>
 * 功能权限表
 * </p>
 *
 * @author yanxin
 * @since 2020-12-24
 */
public class Function implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 功能名称
     */
    private String functionName;

    /**
     * 功能的访问地址
     */
    private String address;

    /**
     * 该功能的父级功能id
     */
    private Integer parentId;

    /**
     * 该功能级别，便于分辨
     */
    private Integer level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Function{" +
            "id=" + id +
            ", functionName=" + functionName +
            ", address=" + address +
            ", parentId=" + parentId +
            ", level=" + level +
        "}";
    }
}
