package com.rent.user.provider.mapper;

import com.heikes.rent_common.pojo.RoleFunction;

import java.util.List;

public interface RoleFunctionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleFunction record);

    RoleFunction selectByPrimaryKey(Long id);

    List<RoleFunction> selectAll();

    int updateByPrimaryKey(RoleFunction record);
}