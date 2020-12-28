package com.heikes.rent_common.house_remote;


import com.heikes.rent_common.pojo.HouseInfo;

public interface InfoRemote {
    int deleteByPrimaryKey(Integer id);

    int insert(HouseInfo record);

    HouseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(HouseInfo record);
}
