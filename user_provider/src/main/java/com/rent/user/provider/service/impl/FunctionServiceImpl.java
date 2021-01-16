package com.rent.user.provider.service.impl;

import com.heikes.rent_common.pojo.Function;
import com.rent.user.provider.mapper.FunctionMapper;
import com.rent.user.provider.service.FunctionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/13
 * @Time:8:20
 */
@Service
@Transactional
public class FunctionServiceImpl implements FunctionService {

    @Resource
    private FunctionMapper functionMapper;

    @Override
    public List<Function> selectFunction(Map<String, Object> map) {
        return functionMapper.selectFunction(map);
    }
}
