package com.rent.user.provider.service;

import com.heikes.rent_common.pojo.User;
import com.heikes.rent_common.vo.PageResult;
import com.heikes.rent_common.pojo.Users;

import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2020/12/29
 * @Time:15:41
 */
public interface UserService {

    boolean insertNormalUser(User user, Long roleId);

    User selectUserImg(String userAccount);

    User selectByLogin(String userAccount, String password);

    User selectUserByColumn(Map<String, Object> columns);

    Boolean updateColumnById(Map<String, Object> map);

    PageResult<Users> selectUserListByColumn(Map<String, Object> map);
}
