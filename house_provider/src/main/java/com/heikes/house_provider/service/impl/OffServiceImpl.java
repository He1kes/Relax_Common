package com.heikes.house_provider.service.impl;

import com.heikes.house_provider.mapper.OffMapper;
import com.heikes.house_provider.service.OffService;
import com.heikes.rent_common.pojo.Off;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class OffServiceImpl implements OffService {
    @Resource
    private OffMapper offMapper;

    @Override
    public List<Off> offAll() {
        return offMapper.offAll();
    }
}
