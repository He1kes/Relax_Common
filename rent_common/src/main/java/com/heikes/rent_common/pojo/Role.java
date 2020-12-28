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
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 关联角色表
     */
    private String roleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
            "id=" + id +
            ", roleName=" + roleName +
        "}";
    }
}
