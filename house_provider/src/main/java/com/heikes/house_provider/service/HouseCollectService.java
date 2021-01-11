package com.heikes.house_provider.service;

import com.heikes.rent_common.pojo.HouseCollect;

public interface HouseCollectService {
    int deleteByPrimaryKey(Integer id);

    //添加心愿单
    int insert(HouseCollect record);

    int insertSelective(HouseCollect record);

    HouseCollect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseCollect record);

    int updateByPrimaryKey(HouseCollect record);
}
