package com.rent.user.provider.mapper;

import com.heikes.rent_common.pojo.UserRole;

import java.util.List;
import java.util.Map;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserRole record);

    UserRole selectByPrimaryKey(Long id);

    List<UserRole> selectAll();

    int updateByPrimaryKey(UserRole record);

    UserRole selectByColumn(Map<String, Object> map);
}