package com.heikes.house_provider.controller;

import com.github.pagehelper.PageInfo;
import com.heikes.house_provider.service.ActivitiesCheckService;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.ActivitiesCheck;
import com.heikes.rent_common.remote.house.ActivitiesCheckRemote;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin(origins = "*")
public class ActivitiesCheckController implements ActivitiesCheckRemote {
    @Resource
    private ActivitiesCheckService activitiesCheckService;

    @Override
    public Bizdto<Integer> insert(ActivitiesCheck activitiesCheck) {
        int count = activitiesCheckService.insert(activitiesCheck);
        Bizdto<Integer> bizdto =new Bizdto<>();
        if (count == 1){
            bizdto.setCode(StatusCode.OK);
            bizdto.setMessage("插入成功");
            bizdto.setData(count);
        }else {
            bizdto.setCode(StatusCode.ERROR);
            bizdto.setMessage("插入失败");
        }
        return bizdto;
    }

    @Override
    public Bizdto<PageInfo<ActivitiesCheck>> allActivitiesCheck(String offDetails) {
        Bizdto<PageInfo<ActivitiesCheck>> bizdto = new Bizdto<>();
        bizdto.setCode(StatusCode.OK);
        bizdto.setMessage("查询成功");
        bizdto.setData(activitiesCheckService.allActivities(offDetails));
        return bizdto;
    }
}
