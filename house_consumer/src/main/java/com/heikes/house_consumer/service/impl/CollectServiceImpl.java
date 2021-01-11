package com.heikes.house_consumer.service.impl;

import com.heikes.house_consumer.client.CollectClient;
import com.heikes.house_consumer.service.CollectService;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.HouseCollect;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CollectServiceImpl implements CollectService {
    @Resource
    private CollectClient collectClient;

    @Override
    public Bizdto<Integer> insert(HouseCollect record) {
        return collectClient.insert(record);
    }
}
