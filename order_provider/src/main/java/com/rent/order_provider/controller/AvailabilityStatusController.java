package com.rent.order_provider.controller;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.AvailabilityStatus;
import com.heikes.rent_common.remote.order.AvailabilityStatusRemote;
import com.rent.order_provider.service.AvailabilityStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AvailabilityStatusController implements AvailabilityStatusRemote {
    @Autowired
    private AvailabilityStatusService availabilityStatusService;

    //添加
    @Override
    public Bizdto<Integer> addStatus(String startDate, String stopDate, Integer houseId) {
        int count = availabilityStatusService.insert(startDate, stopDate, houseId);
        Bizdto<Integer> bizdto = new Bizdto<>();
        if(count > 0){
            bizdto.setCode(StatusCode.OK);
            bizdto.setMessage("addStatus方法执行成功。");
            bizdto.setData(count);
        }else {
            bizdto.setCode(StatusCode.ERROR);
            bizdto.setMessage("addStatus方法执行失败。");
            bizdto.setData(count);
        }
        return bizdto;
    }

    //删除
    @Override
    public Bizdto<Integer> deleteStatus(Integer id) {
        int count = availabilityStatusService.deleteByPrimaryKey(id.longValue());
        Bizdto<Integer> bizdto = new Bizdto<>();
        if(count > 0){
            bizdto.setCode(StatusCode.OK);
            bizdto.setMessage("deleteStatus方法执行成功。");
            bizdto.setData(count);
        }else {
            bizdto.setCode(StatusCode.ERROR);
            bizdto.setMessage("deleteStatus方法执行失败。");
            bizdto.setData(count);
        }
        return bizdto;
    }

    //查询
    @Override
    public Bizdto<Integer> checkStatus(String startDate, String stopDate, Integer houseId) {
        int count = availabilityStatusService.checkHouseStatus(startDate, stopDate, houseId);
        Bizdto<Integer> bizdto = new Bizdto<>();
        if(count == 0){
            bizdto.setCode(StatusCode.OK);
            bizdto.setMessage("checkStatus方法执行成功。");
            bizdto.setData(count);
        }else {
            bizdto.setCode(StatusCode.ERROR);
            bizdto.setMessage("checkStatus方法执行失败。");
            bizdto.setData(count);
        }
        return bizdto;
    }
}
