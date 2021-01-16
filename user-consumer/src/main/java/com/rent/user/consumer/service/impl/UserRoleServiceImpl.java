package com.rent.user.consumer.service.impl;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.UserRole;
import com.rent.user.consumer.client.UserRoleClient;
import com.rent.user.consumer.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/6
 * @Time:20:07
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleClient userRoleClient;
    @Override
    public Bizdto<UserRole> findByColumn(Map<String, Object> map) {
        return userRoleClient.selectByColumn(map);
    }
}
