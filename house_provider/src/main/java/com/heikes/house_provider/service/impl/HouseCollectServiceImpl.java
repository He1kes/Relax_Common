package com.heikes.house_provider.service.impl;

import com.heikes.house_provider.mapper.HouseCollectMapper;
import com.heikes.house_provider.service.HouseCollectService;
import com.heikes.rent_common.pojo.HouseCollect;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HouseCollectServiceImpl implements HouseCollectService {
    @Resource
    private HouseCollectMapper houseCollectMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(HouseCollect record) {
        return houseCollectMapper.insert(record);
    }

    @Override
    public int insertSelective(HouseCollect record) {
        return 0;
    }

    @Override
    public HouseCollect selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(HouseCollect record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(HouseCollect record) {
        return 0;
    }
}
