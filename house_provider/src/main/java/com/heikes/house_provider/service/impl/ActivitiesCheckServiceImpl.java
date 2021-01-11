package com.heikes.house_provider.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heikes.house_provider.mapper.ActivitiesCheckMapper;
import com.heikes.house_provider.service.ActivitiesCheckService;
import com.heikes.rent_common.pojo.ActivitiesCheck;
import com.heikes.rent_common.pojo.HouseInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ActivitiesCheckServiceImpl implements ActivitiesCheckService {

    @Resource
    private ActivitiesCheckMapper activitiesCheckMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(ActivitiesCheck record) {
        return activitiesCheckMapper.insert(record);
    }

    @Override
    public int insertSelective(ActivitiesCheck record) {
        return 0;
    }

    @Override
    public ActivitiesCheck selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(ActivitiesCheck record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(ActivitiesCheck record) {
        return 0;
    }

    @Override
    public PageInfo<ActivitiesCheck> allActivities(String offDetails) {
        List<ActivitiesCheck> list = activitiesCheckMapper.allActivities(offDetails);
        return new PageInfo<ActivitiesCheck>(list,5);
    }
}
