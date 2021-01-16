package com.rent.user.consumer.service.impl;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.Function;
import com.rent.user.consumer.client.FunctionClient;
import com.rent.user.consumer.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/13
 * @Time:8:36
 */
@Service
public class FunctionServiceImpl implements FunctionService {

    @Autowired
    private FunctionClient functionClient;

    @Override
    public Object[] findFunctionList(Object roleId) {
        Map<String, Object> map = new HashMap<>();
        map.put("roleId", roleId);
        map.put("parentId", 0);
        Bizdto<List<Function>> bizdto = functionClient.selectFunction(map);
        //一级分类的list
        List<Function> data = bizdto.getData();
        //存储二级分类的list的list
        List<List<Function>> lists = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            Map<String, Object> objectMap = new HashMap<>();
            objectMap.put("roleId", roleId);
            objectMap.put("parentId", data.get(i).getId());
            lists.add(functionClient.selectFunction(objectMap).getData());
        }
        Object[] objects = {data, lists};
        return objects;
    }
}
