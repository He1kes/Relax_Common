package com.rent.user.consumer.controller;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.User;
import com.heikes.rent_common.vo.ResultVo;
import com.rent.user.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/7
 * @Time:10:26
 */
@RestController
@RequestMapping(value = "/user")
public class UserForOtherController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/front/private/getUserData")
    public ResultVo<List> getUserData(Long userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        Bizdto<User> bizdto = userService.findUserByColumn(map);
        List list = new ArrayList();
        list.add(bizdto.getData());
        list.add(bizdto.getData().getId().toString());
        return new ResultVo<List>(true, bizdto.getCode(), bizdto.getMessage(), list);
    }
}
