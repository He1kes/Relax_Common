package com.heikes.rent_common.pojo;

import java.io.Serializable;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author yanxin
 * @since 2020-12-24
 */
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 角色id
     */
    private Long roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
            "id=" + id +
            ", userId=" + userId +
            ", roleId=" + roleId +
        "}";
    }
}
