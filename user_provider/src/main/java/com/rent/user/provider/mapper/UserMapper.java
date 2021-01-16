package com.rent.user.provider.mapper;

import com.heikes.rent_common.pojo.User;
import com.heikes.rent_common.pojo.Users;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author yanxin
 * @since 2020-12-29
 */
public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User user);

    int updateByPrimaryKey(User user);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    User selectUserImg(String userAccount);

    User selectByLogin(String userAccount, String password);

    User selectUserByColumn(Map<String, Object> columns);

    Boolean updateColumnById(Map<String, Object> map);

    List<Users> selectUserListByColumn(Map<String, Object> map);
}
