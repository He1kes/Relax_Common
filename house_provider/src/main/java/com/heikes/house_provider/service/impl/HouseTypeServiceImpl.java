package com.heikes.house_provider.service.impl;

import com.heikes.house_provider.mapper.HouseTypeMapper;
import com.heikes.house_provider.service.HouseTypeService;
import com.heikes.rent_common.pojo.HouseType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class HouseTypeServiceImpl implements HouseTypeService {
    @Resource
    private HouseTypeMapper houseTypeMapper;

    @Override
    public List<HouseType> allType() {
        return houseTypeMapper.allType();
    }
}
