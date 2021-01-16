package com.rent.user.provider.mapper;

import com.heikes.rent_common.pojo.Function;

import java.util.List;
import java.util.Map;

public interface FunctionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Function record);

    Function selectByPrimaryKey(Long id);

    List<Function> selectAll();

    int updateByPrimaryKey(Function record);

    List<Function> selectFunction(Map<String, Object> map);
}