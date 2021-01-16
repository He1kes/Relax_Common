package com.rent.user.provider.controller;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.UserRole;
import com.heikes.rent_common.remote.user.UserRoleRemote;
import com.rent.user.provider.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/6
 * @Time:19:30
 */
@RestController
@RequestMapping(value = "/userRole")
public class UserRoleController implements UserRoleRemote {

    @Autowired
    private UserRoleService userRoleService;


    @Override
    public Bizdto<UserRole> selectByColumn(Map<String, Object> map) {
        UserRole userRole = userRoleService.selectByColumn(map);
        Bizdto<UserRole> bizdto = new Bizdto<>();
        if (userRole != null) {
            bizdto.setData(userRole);
            bizdto.setMessage("请求成功！");
            bizdto.setCode(StatusCode.OK);
        } else {
            bizdto.setData(userRole);
            bizdto.setMessage("查询为空！");
            bizdto.setCode(StatusCode.OK);
        }
        return bizdto;
    }
}
