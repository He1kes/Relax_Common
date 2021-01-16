package com.rent.user.provider.controller;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.Role;
import com.heikes.rent_common.remote.user.RoleRemote;
import com.heikes.rent_common.vo.PageResult;
import com.rent.user.provider.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/11
 * @Time:10:06
 */
@RestController
@RequestMapping(value = "/role")
public class RoleController implements RoleRemote {

    @Autowired
    private RoleService roleService;

    @Override
    public Bizdto<List<Role>> selectRoles(Map<String, Object> map) {
        List<Role> lists = roleService.selectRoles(map);
        Bizdto<List<Role>> bizdto = new Bizdto<>();
        bizdto.setData(lists);
        bizdto.setMessage("请求成功");
        bizdto.setCode(StatusCode.OK);
        return bizdto;
    }

    @Override
    public Bizdto<PageResult<Role>> selectRoleByPage(Integer pageNum, Integer pageSize) {
        PageResult<Role> pageResult = roleService.selectRoleByPage(pageNum, pageSize);
        Bizdto<PageResult<Role>> bizdtoz = new Bizdto<>();
        bizdtoz.setData(pageResult);
        bizdtoz.setCode(StatusCode.OK);
        bizdtoz.setMessage("请求成功！");
        return bizdtoz;
    }
}
