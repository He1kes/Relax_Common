package com.rent.user.provider.service;

import com.heikes.rent_common.pojo.Function;

import java.util.List;
import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/13
 * @Time:8:19
 */
public interface FunctionService {

    List<Function> selectFunction(Map<String, Object> map);
}
