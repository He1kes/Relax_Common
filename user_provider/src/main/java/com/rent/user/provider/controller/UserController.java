package com.rent.user.provider.controller;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.User;
import com.heikes.rent_common.remote.user.UserRemote;
import com.heikes.rent_common.vo.PageResult;
import com.heikes.rent_common.pojo.Users;
import com.rent.user.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2020/12/30
 * @Time:8:21
 */
@RestController
@RequestMapping(value = "/user")
public class UserController implements UserRemote {

    @Autowired
    private UserService userService;

    /**
     * @param user
     * @return
     * 添加普通用户
     */
    @Override
    public Bizdto<Boolean> addNormalUser(User user, Long roleId) {
        boolean flag = userService.insertNormalUser(user, roleId);
        Bizdto<Boolean> bizdto = new Bizdto<>();
        bizdto.setData(flag);
        bizdto.setMessage("请求成功！");
        bizdto.setCode(StatusCode.OK);
        return bizdto;
    }

    /**
     * @param userAccount
     * @return
     * 查询用户头像地址
     */
    @Override
    public Bizdto<User> selectUserImg(String userAccount) {
        User user = userService.selectUserImg(userAccount);
        Bizdto<User> bizdto = new Bizdto<>();
        bizdto.setData(user);
        bizdto.setMessage("请求成功！");
        bizdto.setCode(StatusCode.OK);
        return bizdto;
    }

    /**
     * @param userAccount
     * @param password
     * @return
     * 根据用户账号和密码查询
     */
    @Override
    public Bizdto<User> selectByLogin(String userAccount, String password) {
        User user = userService.selectByLogin(userAccount, password);
        Bizdto<User> bizdto = new Bizdto<>();
        bizdto.setData(user);
        bizdto.setMessage("请求成功！");
        bizdto.setCode(StatusCode.OK);
        return bizdto;
    }

    @Override
    public Bizdto<User> selectUserByColumn(Map<String, Object> columns) {
        User user = userService.selectUserByColumn(columns);
        Bizdto<User> bizdto = new Bizdto<>();
        bizdto.setData(user);
        bizdto.setMessage("请求成功！");
        bizdto.setCode(StatusCode.OK);
        return bizdto;
    }

    @Override
    public Bizdto<Boolean> updateColumnById(Map<String, Object> map) {
        Boolean flag = userService.updateColumnById(map);
        Bizdto<Boolean> bizdto = new Bizdto<>();
        bizdto.setData(flag);
        bizdto.setMessage("请求成功！");
        bizdto.setCode(StatusCode.OK);
        return bizdto;
    }

    @Override
    public Bizdto<PageResult<Users>> selectUserListByColumn(Map<String, Object> map) {
        PageResult<Users> pageResult = userService.selectUserListByColumn(map);
        Bizdto<PageResult<Users>> bizdto = new Bizdto<>();
        bizdto.setData(pageResult);
        bizdto.setMessage("请求成功！");
        bizdto.setCode(StatusCode.OK);
        return bizdto;
    }
}
