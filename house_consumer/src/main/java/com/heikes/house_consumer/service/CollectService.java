package com.heikes.house_consumer.service;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.HouseCollect;

public interface CollectService {
    //添加心愿单
    Bizdto<Integer> insert(HouseCollect record);
}
