package com.heikes.house_consumer.service.impl;

import com.heikes.house_consumer.client.TypeClient;
import com.heikes.house_consumer.service.TypeService;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.HouseType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TypeServiceImpl implements TypeService {
    @Resource
    private TypeClient client;
    @Override
    public Bizdto<List<HouseType>> allType() {
        return client.getAllHouseType();
    }
}
