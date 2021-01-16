package com.rent.user.consumer.service;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.Role;
import com.heikes.rent_common.vo.PageResult;

import java.util.List;
import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/11
 * @Time:9:57
 */
public interface RoleService {
    Bizdto<List<Role>> getRoles(Map<String, Object> map);

    Bizdto<PageResult<Role>> findRoleByPage(Integer pageNum, Integer pageSize);
}
