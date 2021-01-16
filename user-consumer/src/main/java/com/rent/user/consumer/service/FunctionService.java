package com.rent.user.consumer.service;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.Function;

import java.util.List;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/13
 * @Time:8:35
 */
public interface FunctionService {

    Object[] findFunctionList(Object roleId);
}
