package com.rent.user.consumer.service;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.User;
import com.heikes.rent_common.pojo.Users;
import com.heikes.rent_common.vo.PageResult;

import java.util.List;
import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2020/12/30
 * @Time:11:04
 */
public interface UserService {

    Bizdto<Boolean> insertNormalUser(User user, Long roleId);

    Bizdto<User> findUserImg(String userAccount);

    Bizdto<User> doLogin(String userAccount, String password);

    Bizdto<User> findUserByColumn(Map<String, Object> columns);

    Bizdto<Boolean> updateColumnById(Map<String, Object> map);

    Bizdto<PageResult<Users>> findUserListByColumn(Map<String, Object> map);
}
