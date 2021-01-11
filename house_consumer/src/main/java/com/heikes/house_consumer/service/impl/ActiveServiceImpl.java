package com.heikes.house_consumer.service.impl;

import com.github.pagehelper.PageInfo;
import com.heikes.house_consumer.client.ActiveClient;
import com.heikes.house_consumer.service.ActiveService;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.ActivitiesCheck;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ActiveServiceImpl implements ActiveService {
    @Resource
    private ActiveClient activeClient;

    @Override
    public Bizdto<Integer> insert(ActivitiesCheck record) {
        return activeClient.insert(record);
    }

    @Override
    public Bizdto<PageInfo<ActivitiesCheck>> allActivities(String offDetails) {
        return activeClient.allActivitiesCheck(offDetails);
    }
}
