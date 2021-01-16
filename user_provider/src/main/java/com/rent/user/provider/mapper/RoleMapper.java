package com.rent.user.provider.mapper;

import com.heikes.rent_common.pojo.Role;

import java.util.List;
import java.util.Map;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    Role selectByPrimaryKey(Long id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    List<Role> selectRoles(Map<String, Object> map);

    List<Role> selectRoleByPage();
}