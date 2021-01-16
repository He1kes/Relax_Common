package com.rent.user.consumer.controller;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.Role;
import com.heikes.rent_common.pojo.User;
import com.heikes.rent_common.pojo.UserRole;
import com.heikes.rent_common.pojo.Users;
import com.heikes.rent_common.vo.PageResult;
import com.heikes.rent_common.vo.ResultVo;
import com.rent.user.consumer.service.RoleService;
import com.rent.user.consumer.service.UserRoleService;
import com.rent.user.consumer.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/11
 * @Time:9:48
 */
@RequestMapping(value = "/user")
@RestController
public class UserBackController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/back/getRoles")
    public ResultVo<List<Role>> getRoles(HttpServletRequest request) {
        String roleId = request.getHeader("roleId");
        Map<String, Object> map = new HashMap<>();
        map.put("roleId", roleId);
        Bizdto<List<Role>> bizdto = roleService.getRoles(map);
        return new ResultVo<List<Role>>(true, bizdto.getCode(), bizdto.getMessage(), bizdto.getData());
    }

    @PostMapping(value = "/back/getUserList")
    public ResultVo<PageResult<Users>> getUserList(String userAccount,
                                                   String userName,
                                                   String roleId,
                                                   String pageNum,
                                                   String pageSize,
                                                   HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        String requestRoleId = request.getHeader("roleId");
        map.put("requestRoleId", requestRoleId);
        if (StringUtils.isNotBlank(userName)) {
            map.put("userName", userName);
        }

        if (StringUtils.isNotBlank(userAccount)) {
            map.put("userAccount", userAccount);
        }

        if (StringUtils.isNotBlank(roleId)) {
            map.put("roleId", roleId);
        }
        Bizdto<PageResult<Users>> bizdto = userService.findUserListByColumn(map);
        if (bizdto.getData().getList().size() >= 0) {
            return new ResultVo<PageResult<Users>>(true, bizdto.getCode(), bizdto.getMessage(), bizdto.getData());
        } else {
            return new ResultVo<PageResult<Users>>(false, bizdto.getCode(), bizdto.getMessage(), null);
        }
    }

    @PostMapping(value = "/back/bannedUser")
    public ResultVo<Boolean> bannedUser(String userId, Integer userStatus, HttpServletRequest request) {
        //判断是否够级别执行封禁
        int roleId = Integer.parseInt(request.getHeader("roleId"));
        //当前登录用户的id
        String id = request.getHeader("userId");
        Map<String, Object> column = new HashMap<>();
        column.put("userId", userId);
        //要修改的用户的信息
        Bizdto<UserRole> roleBizdto = userRoleService.findByColumn(column);
        if (roleBizdto.getData().getRoleId() > roleId) {
            //执行封禁
            Map<String, Object> map = new HashMap<>();
            map.put("userId", userId);
            if (userStatus.intValue() == 0) {
                userStatus = 1;
            } else {
                userStatus = 0;
            }
            map.put("userStatus", userStatus);
            Bizdto<Boolean> bizdto = userService.updateColumnById(map);
            return new ResultVo<Boolean>(true, bizdto.getCode(), bizdto.getMessage(), bizdto.getData());
        } else {
            return new ResultVo<Boolean>(true, StatusCode.ACCESSERROR, "权限不足", false);
        }
    }

    @PostMapping(value = "/back/resetPassword")
    public ResultVo<Boolean> resetPassword(String userId, HttpServletRequest request) {
        //判断是否够级别执行封禁
        int roleId = Integer.parseInt(request.getHeader("roleId"));
        //当前登录用户的id
        String id = request.getHeader("userId");
        Map<String, Object> column = new HashMap<>();
        column.put("userId", userId);
        //要修改的用户的信息
        Bizdto<UserRole> roleBizdto = userRoleService.findByColumn(column);
        if (roleBizdto.getData().getRoleId() > roleId) {
            //执行密码重置
            Map<String, Object> map = new HashMap<>();
            map.put("userId", userId);
            map.put("password", "000000");
            Bizdto<Boolean> bizdto = userService.updateColumnById(map);
            return new ResultVo<Boolean>(true, bizdto.getCode(), bizdto.getMessage(), bizdto.getData());
        } else {
            return new ResultVo<Boolean>(true, StatusCode.ACCESSERROR, "权限不足", false);
        }
    }

    @PostMapping(value = "/back/private/addManager")
    public ResultVo<Boolean> addManager(User user, HttpServletRequest request) {
        int roleId = Integer.parseInt(request.getHeader("roleId"));
        if (roleId == 1) {
            Bizdto<Boolean> bizdto = userService.insertNormalUser(user, 2L);
            return new ResultVo<Boolean>(true, bizdto.getCode(), bizdto.getMessage(), bizdto.getData());
        } else {
            return new ResultVo<Boolean>(true, StatusCode.ACCESSERROR, "权限不足", false);
        }
    }
}
