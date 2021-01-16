package com.rent.user.provider.service.impl;

import com.heikes.rent_common.pojo.UserRole;
import com.rent.user.provider.mapper.UserRoleMapper;
import com.rent.user.provider.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/6
 * @Time:19:26
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public boolean deleteByPrimaryKey(Long id) {
        return userRoleMapper.deleteByPrimaryKey(id) == 1;
    }

    @Override
    public boolean insert(UserRole record) {
        return userRoleMapper.insert(record) == 1;
    }

    @Override
    public UserRole selectByPrimaryKey(Long id) {
        return userRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UserRole> selectAll() {
        return userRoleMapper.selectAll();
    }

    @Override
    public boolean updateByPrimaryKey(UserRole record) {
        return userRoleMapper.updateByPrimaryKey(record) == 1;
    }

    @Override
    public UserRole selectByColumn(Map<String, Object> map) {
        return userRoleMapper.selectByColumn(map);
    }
}
