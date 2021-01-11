package com.heikes.house_consumer.controller;

import com.heikes.house_consumer.service.CollectService;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.HouseCollect;
import com.heikes.rent_common.vo.ResultVo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin(origins = "*")
public class CollectController {
    @Resource
    private CollectService service;

    //添加心愿单
    @RequestMapping("/collect/addCollect")
    public ResultVo<Integer> insert(@RequestBody HouseCollect houseCollect){
        Bizdto<Integer> bizdto = service.insert(houseCollect);
        boolean flag = false;
        if (bizdto.getData() == 1){
            flag = true;
            return new ResultVo<>(flag, StatusCode.OK, bizdto.getMessage(), bizdto.getData());
        }
        return new ResultVo<>(flag,bizdto.getCode(), bizdto.getMessage(), bizdto.getData());
    }
}
