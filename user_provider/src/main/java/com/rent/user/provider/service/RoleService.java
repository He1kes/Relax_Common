package com.rent.user.provider.service;

import com.heikes.rent_common.pojo.Role;
import com.heikes.rent_common.vo.PageResult;

import java.util.List;
import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/11
 * @Time:10:09
 */
public interface RoleService {
    List<Role> selectRoles(Map<String, Object> map);

    PageResult<Role> selectRoleByPage(Integer pageNum, Integer pageSize);
}
