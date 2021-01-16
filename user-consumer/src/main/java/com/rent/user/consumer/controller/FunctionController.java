package com.rent.user.consumer.controller;

import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.Function;
import com.heikes.rent_common.vo.ResultVo;
import com.rent.user.consumer.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/13
 * @Time:8:38
 */
@RestController
@RequestMapping(value = "/user/function")
public class FunctionController {

    @Autowired
    private FunctionService functionService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping(value = "/back/getFunction")
    public ResultVo getFunction(HttpServletRequest request) {
        String token = request.getHeader("token");
        token = token == null ? "" : token;
        Object roleId = stringRedisTemplate.opsForHash().get(token, "roleId");
        Object[] objects = functionService.findFunctionList(roleId);
        return new ResultVo(true, StatusCode.OK, "请求成功！", objects);
    }

    @GetMapping(value = "/back/findFunction")
    public ResultVo findFunction(@RequestParam(required = false) Integer roleId) {
        Object[] functionList = functionService.findFunctionList(roleId);
        return new ResultVo(true, StatusCode.OK, "请求成功！", functionList);
    }
}
