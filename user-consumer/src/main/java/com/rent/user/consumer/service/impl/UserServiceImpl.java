package com.rent.user.consumer.service.impl;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.User;
import com.heikes.rent_common.pojo.Users;
import com.heikes.rent_common.vo.PageResult;
import com.rent.user.consumer.client.UserClient;
import com.rent.user.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2020/12/30
 * @Time:13:41
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserClient userClient;

    @Override
    public Bizdto<Boolean> insertNormalUser(User user, Long roleId) {
        return userClient.addNormalUser(user, roleId);
    }

    @Override
    public Bizdto<User> findUserImg(String userAccount) {
        return userClient.selectUserImg(userAccount);
    }

    @Override
    public Bizdto<User> doLogin(String userAccount, String password) {
        return userClient.selectByLogin(userAccount, password);
    }

    @Override
    public Bizdto<User> findUserByColumn(Map<String, Object> columns) {
        return userClient.selectUserByColumn(columns);
    }

    @Override
    public Bizdto<Boolean> updateColumnById(Map<String, Object> map) {
        return userClient.updateColumnById(map);
    }

    @Override
    public Bizdto<PageResult<Users>> findUserListByColumn(Map<String, Object> map) {
        return userClient.selectUserListByColumn(map);
    }

}
