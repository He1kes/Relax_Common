package com.heikes.house_consumer.controller;

import com.github.pagehelper.PageInfo;
import com.heikes.house_consumer.service.ActiveService;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.ActivitiesCheck;
import com.heikes.rent_common.vo.ResultVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/consumer/back/active")
public class ActiveController {
    @Resource
    private ActiveService service;

    //发出促销请求
    @RequestMapping("/addActivitiesCheck")
    public ResultVo<Integer> insert(@RequestBody ActivitiesCheck activitiesCheck){
        Bizdto<Integer> bizdto = service.insert(activitiesCheck);
        boolean flag = false;
        if (bizdto.getData() == 1){
            flag = true;
            return new ResultVo<>(flag, StatusCode.OK,bizdto.getMessage(),bizdto.getData());
        }
        return new ResultVo<>(flag,bizdto.getCode(),bizdto.getMessage(),bizdto.getData());
    }

    //查询全部商户促销
    @RequestMapping("/allActivitiesCheck")
    public ResultVo<PageInfo<ActivitiesCheck>> allActivitiesCheck(@RequestParam("offDetails") String offDetails){
        Bizdto<PageInfo<ActivitiesCheck>> bizdto = service.allActivities(offDetails);
        boolean flag = false;
        if (bizdto.getData() != null){
            flag = true;
            return new ResultVo<>(flag, StatusCode.OK, bizdto.getMessage(),bizdto.getData());
        }
        return new ResultVo<>(flag,bizdto.getCode(),bizdto.getMessage(),bizdto.getData());
    }
}
