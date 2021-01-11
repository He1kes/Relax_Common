package com.heikes.house_consumer.service;

import com.github.pagehelper.PageInfo;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.ActivitiesCheck;

public interface ActiveService {
    //发布促销请求
    Bizdto<Integer> insert(ActivitiesCheck record);

    //全部促销活动
    Bizdto<PageInfo<ActivitiesCheck>> allActivities(String offDetails);
}
