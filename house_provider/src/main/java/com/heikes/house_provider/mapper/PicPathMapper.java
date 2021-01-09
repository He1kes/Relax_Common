package com.heikes.house_provider.mapper;

import com.heikes.rent_common.pojo.PicPath;

import java.util.List;

public interface PicPathMapper {
    int deleteByPrimaryKey(Integer id);

    //新增
    int insert(PicPath record);

    int insertSelective(PicPath record);

    PicPath selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PicPath record);

    int updateByPrimaryKey(PicPath record);

    //查询房源id全部图片路径
    List<PicPath> allPath(Integer houseId);
}