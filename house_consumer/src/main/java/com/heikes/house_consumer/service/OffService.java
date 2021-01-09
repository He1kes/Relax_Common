package com.heikes.house_consumer.service;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.Off;

import java.util.List;

public interface OffService {
    //查询全部政策
    Bizdto<List<Off>> offAll();
}
