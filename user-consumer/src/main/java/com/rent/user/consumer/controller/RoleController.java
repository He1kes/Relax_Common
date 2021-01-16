package com.rent.user.consumer.controller;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.Role;
import com.heikes.rent_common.vo.PageResult;
import com.heikes.rent_common.vo.ResultVo;
import com.rent.user.consumer.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/13
 * @Time:15:32
 */
@RestController
@RequestMapping(value = "/user/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping(value = "/back/getRoleByPage")
    public ResultVo<PageResult<Role>> getRoleByPage(Integer pageNum, Integer pageSize) {
        Bizdto<PageResult<Role>> bizdto = roleService.findRoleByPage(pageNum, pageSize);
        return new ResultVo<PageResult<Role>>(true, bizdto.getCode(), bizdto.getMessage(), bizdto.getData());
    }
}
