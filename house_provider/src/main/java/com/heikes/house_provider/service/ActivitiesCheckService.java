package com.heikes.house_provider.service;

import com.github.pagehelper.PageInfo;
import com.heikes.rent_common.pojo.ActivitiesCheck;

import java.util.List;

public interface ActivitiesCheckService {
    int deleteByPrimaryKey(Integer id);

    //发布促销请求
    int insert(ActivitiesCheck record);

    int insertSelective(ActivitiesCheck record);

    ActivitiesCheck selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ActivitiesCheck record);

    int updateByPrimaryKey(ActivitiesCheck record);

    //全部促销活动
    PageInfo<ActivitiesCheck> allActivities(String offDetails);
}
