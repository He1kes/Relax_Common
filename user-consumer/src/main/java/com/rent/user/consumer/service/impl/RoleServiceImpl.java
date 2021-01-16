package com.rent.user.consumer.service.impl;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.Role;
import com.heikes.rent_common.vo.PageResult;
import com.rent.user.consumer.client.RoleClient;
import com.rent.user.consumer.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/11
 * @Time:9:57
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleClient roleClient;

    @Override
    public Bizdto<List<Role>> getRoles(Map<String, Object> map) {
        return roleClient.selectRoles(map);
    }

    @Override
    public Bizdto<PageResult<Role>> findRoleByPage(Integer pageNum, Integer pageSize) {
        return roleClient.selectRoleByPage(pageNum, pageSize);
    }
}
