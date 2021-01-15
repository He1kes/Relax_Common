package com.heikes.house_consumer.service;

import com.github.pagehelper.PageInfo;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.CancelPolicy;
import com.heikes.rent_common.pojo.HouseInfo;
import org.springframework.web.multipart.MultipartFile;

public interface InfoService {
    //新增
    Bizdto<Integer> insert(HouseInfo record);

    //根据id查询
    Bizdto<HouseInfo> selectByPrimaryKey(Integer id);

    //修改
    Bizdto<Integer> updateByPrimaryKey(HouseInfo record);

    //审核
    Bizdto<Integer> checkPass(Integer id);

    //下架
    Bizdto<Integer> checkStop(Integer id);

    //后台房源查询管理员
    Bizdto<PageInfo<HouseInfo>> BackAdminall(Integer pageNum, Integer pageSize, String landlordName, String address);

    //后台未审核房源查询管理员
    Bizdto<PageInfo<HouseInfo>> BackAdminallCheck(Integer pageNum, Integer pageSize,String landlordName, String address);

    //前台房源查询
    Bizdto<PageInfo<HouseInfo>> Fontall(Integer pageNum,Integer pageSize,Integer houseType,Integer area,Integer rent,String address);

    //后台查询房源商家
    Bizdto<PageInfo<HouseInfo>> BackBussall(Integer pageNum,Integer pageSize,String address,Integer checkStatus,Long id);

    //通过活动请求
    Bizdto<Integer> activePass(Integer id);

    //根据id查询取消政策
    Bizdto<CancelPolicy> Cancel(Integer id);
}
