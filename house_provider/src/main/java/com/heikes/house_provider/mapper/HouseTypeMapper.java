package com.heikes.house_provider.mapper;

import com.heikes.rent_common.pojo.HouseType;

import java.util.List;

public interface HouseTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HouseType record);

    int insertSelective(HouseType record);

    HouseType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HouseType record);

    int updateByPrimaryKey(HouseType record);

    //全部房屋类型
    List<HouseType> allType();
}