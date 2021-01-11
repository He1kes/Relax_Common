package com.heikes.house_provider.service;

import com.github.pagehelper.PageInfo;
import com.heikes.rent_common.pojo.CancelPolicy;
import com.heikes.rent_common.pojo.HouseInfo;

import java.util.List;

public interface HouseInfoService {
    int deleteByPrimaryKey(Integer id);

    //新增
    int insert(HouseInfo houseInfo);

    int insertSelective(HouseInfo record);

    //根据id查询
    HouseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseInfo record);

    //修改
    int updateByPrimaryKey(HouseInfo record);

    //审核
    int checkPass(Integer id);
    //下架
    int checkStop(Integer id);
    //后台房源查询管理员
    PageInfo<HouseInfo> BackAdminall(Integer pageNum,Integer pageSize,String landlordName,String address);
    //后台未审核房源查询管理员
    PageInfo<HouseInfo> BackAdminallCheck(Integer pageNum, Integer pageSize,String landlordName, String address);
    //前台房源查询
    PageInfo<HouseInfo> Fontall(Integer pageNum,Integer pageSize,Integer houseType,Integer area,Integer rent,String address);
    //后台查询房源商家
    PageInfo<HouseInfo> BackBussall(Integer pageNum,Integer pageSize,String address,Integer checkStatus);
    //通过活动请求
    int activePass(Integer id);
    //根据id查询取消政策
    CancelPolicy Cancel(Integer id);
}
