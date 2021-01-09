package com.heikes.house_consumer.controller;

import com.heikes.house_consumer.service.OffService;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.Off;
import com.heikes.rent_common.vo.ResultVo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/consumer/off")
public class OffController {
    @Resource
    private OffService offService;

    //查询全部活动政策
    @RequestMapping("/back/allOff")
    public ResultVo<List<Off>> allOff(){
        Bizdto<List<Off>> bizdto = offService.offAll();
        boolean flag = false;
        if (bizdto.getData() != null){
            flag = true;
            return new ResultVo<>(flag, StatusCode.OK, bizdto.getMessage(), bizdto.getData());
        }
        return new ResultVo<>(flag, bizdto.getCode(), bizdto.getMessage(), bizdto.getData());
    }
}
