package com.heikes.house_consumer.service;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.HouseType;

import java.util.List;

public interface TypeService {
    //全部房屋类型
    Bizdto<List<HouseType>> allType();
}
