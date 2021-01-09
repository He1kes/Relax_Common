package com.heikes.house_consumer.controller;

import com.heikes.house_consumer.service.TypeService;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.HouseType;
import com.heikes.rent_common.vo.ResultVo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/consumer/type")
public class TypeController {
    @Resource
    private TypeService service;

    //全部房屋类型
    @RequestMapping("/font/public/allHouseType")
    public ResultVo<List<HouseType>> getAllHouseType(){
        Bizdto<List<HouseType>> bizdto = service.allType();
        boolean flag = false;
        if (bizdto.getData() != null){
            flag = true;
            return new ResultVo<>(flag, StatusCode.OK, bizdto.getMessage(), bizdto.getData());
        }
        return new ResultVo<>(flag, bizdto.getCode(), bizdto.getMessage(), bizdto.getData());
    }
}
