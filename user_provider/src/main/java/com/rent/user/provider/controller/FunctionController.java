package com.rent.user.provider.controller;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.Function;
import com.heikes.rent_common.remote.user.FunctionRemote;
import com.rent.user.provider.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/13
 * @Time:8:27
 */
@RestController
@RequestMapping(value = "/function")
public class FunctionController implements FunctionRemote {

    @Autowired
    private FunctionService functionService;

    @Override
    public Bizdto<List<Function>> selectFunction(Map<String, Object> map) {
        List<Function> functions = functionService.selectFunction(map);
        Bizdto<List<Function>> bizdto = new Bizdto<>();
        bizdto.setData(functions);
        bizdto.setCode(StatusCode.OK);
        bizdto.setMessage("请求成功！");
        return bizdto;
    }
}
