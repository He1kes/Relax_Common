package com.heikes.house_consumer.service.impl;

import com.github.pagehelper.PageInfo;
import com.heikes.house_consumer.client.InfoClient;
import com.heikes.house_consumer.service.InfoService;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.CancelPolicy;
import com.heikes.rent_common.pojo.HouseInfo;
import com.heikes.rent_common.remote.house.InfoRemote;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Service
public class InfoServiceImpl implements InfoService {
    @Resource
    private InfoClient infoClient;

    @Override
    public Bizdto<Integer> insert(HouseInfo record) {
        return infoClient.addHouseInfo(record);
    }

    @Override
    public Bizdto<HouseInfo> selectByPrimaryKey(Integer id) {
        return infoClient.getHouseInfoById(id);
    }

    @Override
    public Bizdto<Integer> updateByPrimaryKey(HouseInfo record) {
        return infoClient.updateHouseInfo(record);
    }

    @Override
    public Bizdto<Integer> checkPass(Integer id) {
        return infoClient.HouseCheckPass(id);
    }

    @Override
    public Bizdto<Integer> checkStop(Integer id) {
        return infoClient.HouseCheckStop(id);
    }

    @Override
    public Bizdto<PageInfo<HouseInfo>> BackAdminall(Integer pageNum, Integer pageSize, String landlordName, String address) {
        return infoClient.BackAdminall(pageNum, pageSize, landlordName, address);
    }

    @Override
    public Bizdto<PageInfo<HouseInfo>> BackAdminallCheck(Integer pageNum, Integer pageSize, String landlordName, String address) {
        return infoClient.BackAdminCheck(pageNum, pageSize, landlordName, address);
    }

    @Override
    public Bizdto<PageInfo<HouseInfo>> Fontall(Integer pageNum, Integer pageSize, Integer houseType, Integer area, Integer rent, String address) {
        return infoClient.Fontall(pageNum, pageSize, houseType, area, rent, address);
    }

    @Override
    public Bizdto<PageInfo<HouseInfo>> BackBussall(Integer pageNum, Integer pageSize, String address, Integer checkStatus) {
        return infoClient.BackBussall(pageNum, pageSize, address, checkStatus);
    }

    @Override
    public Bizdto<Integer> activePass(Integer id) {
        return infoClient.activePass(id);
    }

    @Override
    public Bizdto<CancelPolicy> Cancel(Integer id) {
        return infoClient.cancel(id);
    }
}
