package com.rent.order_consumer.controller;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.vo.ResultVo;
import com.rent.order_consumer.service.AvailabilityStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AvailabilityStatusController {
    @Autowired
    private AvailabilityStatusService availabilityStatusService;

    //添加
    @RequestMapping("/status/addStatus")
    ResultVo<Integer> addStatus(@RequestParam("startDate") String startDate,
                                @RequestParam("stopDate") String stopDate,
                                @RequestParam("houseId") Integer houseId){
        Bizdto<Integer> bizdto = availabilityStatusService.addStatus(startDate, stopDate, houseId);
        ResultVo<Integer> resultVo = new ResultVo<>();
        if(bizdto.getCode() == StatusCode.OK){
            resultVo.setFlag(true);
            resultVo.setData(bizdto.getData());
        }else {
            resultVo.setFlag(false);
            resultVo.setMessage("addStatus获取数据出现错误ord-cons-c！");
        }
        return resultVo;
    }
    //删除
    @RequestMapping("/status/deleteStatus")
    ResultVo<Integer> deleteStatus(@RequestParam("id") Integer id){
        Bizdto<Integer> bizdto = availabilityStatusService.deleteStatus(id);
        ResultVo<Integer> resultVo = new ResultVo<>();
        if(bizdto.getCode() == StatusCode.OK){
            resultVo.setFlag(true);
            resultVo.setData(bizdto.getData());
        }else {
            resultVo.setFlag(false);
            resultVo.setMessage("deleteStatus获取数据出现错误ord-cons-c！");
        }
        return resultVo;
    }
    //查询
    @RequestMapping("/status/checkStatus")
    ResultVo<Integer> checkStatus(@RequestParam("startDate") String startDate,
                                @RequestParam("stopDate") String stopDate,
                                @RequestParam("hosueId") Integer houseId){
        Bizdto<Integer> bizdto = availabilityStatusService.checkStatus(startDate, stopDate, houseId);
        ResultVo<Integer> resultVo = new ResultVo<>();
        if(bizdto.getCode() == StatusCode.OK){
            resultVo.setFlag(true);
            resultVo.setData(bizdto.getData());
        }else {
            resultVo.setFlag(false);
            resultVo.setMessage("checkStatus获取数据出现错误ord-cons-c！");
        }
        return resultVo;
    }
}
