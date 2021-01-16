package com.rent.user.provider.service;

import com.heikes.rent_common.pojo.UserRole;

import java.util.List;
import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/6
 * @Time:19:25
 */
public interface UserRoleService {

    boolean deleteByPrimaryKey(Long id);

    boolean insert(UserRole record);

    UserRole selectByPrimaryKey(Long id);

    List<UserRole> selectAll();

    boolean updateByPrimaryKey(UserRole record);

    UserRole selectByColumn(Map<String, Object> map);
}
