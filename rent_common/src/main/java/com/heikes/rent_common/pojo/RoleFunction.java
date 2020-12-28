package com.heikes.rent_common.pojo;

import java.io.Serializable;

/**
 * <p>
 * 角色功能表
 * </p>
 *
 * @author yanxin
 * @since 2020-12-24
 */
public class RoleFunction implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 关联角色表
     */
    private Integer roleId;

    /**
     * 关联功能表
     */
    private Integer functionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    @Override
    public String toString() {
        return "RoleFunction{" +
            "id=" + id +
            ", roleId=" + roleId +
            ", functionId=" + functionId +
        "}";
    }
}
