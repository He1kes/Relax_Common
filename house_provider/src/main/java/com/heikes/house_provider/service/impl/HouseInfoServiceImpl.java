package com.heikes.house_provider.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heikes.house_provider.mapper.HouseInfoMapper;
import com.heikes.house_provider.mapper.PicPathMapper;
import com.heikes.house_provider.service.HouseInfoService;
import com.heikes.rent_common.pojo.CancelPolicy;
import com.heikes.rent_common.pojo.HouseInfo;
import com.heikes.rent_common.pojo.PicPath;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class HouseInfoServiceImpl implements HouseInfoService {
    @Resource
    private HouseInfoMapper houseInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(HouseInfo houseInfo) {
        return houseInfoMapper.insert(houseInfo);
    }

    @Override
    public int insertSelective(HouseInfo record) {
        return 0;
    }

    @Override
    public HouseInfo selectByPrimaryKey(Integer id) {
        return houseInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(HouseInfo record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(HouseInfo record) {
        return 0;
    }

    @Override
    public int checkPass(Integer id) {
        return houseInfoMapper.checkPass(id);
    }

    @Override
    public int checkStop(Integer id) {
        return houseInfoMapper.checkStop(id);
    }

    @Override
    public PageInfo<HouseInfo> BackAdminall(Integer pageNum, Integer pageSize, String landlordName, String address) {
        PageHelper.startPage(pageNum,pageSize);
        List<HouseInfo> list = houseInfoMapper.BackAdminall(landlordName, address);
        return new PageInfo<HouseInfo>(list,5);
    }

    @Override
    public PageInfo<HouseInfo> BackAdminallCheck(Integer pageNum, Integer pageSize,String landlordName, String address) {
        PageHelper.startPage(pageNum,pageSize);
        List<HouseInfo> list = houseInfoMapper.BackAdminallCheck(landlordName, address);
        return new PageInfo<HouseInfo>(list,5);
    }

    @Override
    public PageInfo<HouseInfo> Fontall(Integer pageNum, Integer pageSize, Integer houseType, Integer area, Integer rent, String address) {
        PageHelper.startPage(pageNum,pageSize);
        List<HouseInfo> list = houseInfoMapper.Fontall(houseType, area, rent, address);
        return new PageInfo<HouseInfo>(list,5);
    }

    @Override
    public PageInfo<HouseInfo> BackBussall(Integer pageNum, Integer pageSize, String address, Integer checkStatus,Long id) {
        PageHelper.startPage(pageNum,pageSize);
        List<HouseInfo> list = houseInfoMapper.BackBussall(address, checkStatus,id);
        return new PageInfo<HouseInfo>(list,5);
    }

    @Override
    public int activePass(Integer id) {
        return houseInfoMapper.activePass(id);
    }

    @Override
    public CancelPolicy Cancel(Integer id) {
        return houseInfoMapper.cancel(id);
    }
}
