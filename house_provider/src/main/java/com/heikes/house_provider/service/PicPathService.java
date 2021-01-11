package com.heikes.house_provider.service;

import com.heikes.rent_common.pojo.PicPath;

import java.io.InputStream;
import java.util.List;

public interface PicPathService {
    //新增
    int insert(String path,Integer houseId);

    //查询房源id全部图片路径
    List<PicPath> allPath(Integer houseId);
}
