package com.heikes.house_provider.mapper;

import com.heikes.rent_common.pojo.Off;

import java.util.List;

public interface OffMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Off record);

    int insertSelective(Off record);

    Off selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Off record);

    int updateByPrimaryKey(Off record);

    //查询全部政策
    List<Off> offAll();
}