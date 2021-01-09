package com.heikes.house_consumer.service;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.PicPath;

import java.util.List;

public interface PicpathService {
    //新增
    Bizdto<Integer> insert(String path, Integer houseId);

    //查询房源id全部图片路径
    Bizdto<List<PicPath>> allPath(Integer houseId);
}
