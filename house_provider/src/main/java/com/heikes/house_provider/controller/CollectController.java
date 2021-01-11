package com.heikes.house_provider.controller;

import com.heikes.house_provider.service.HouseCollectService;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.HouseCollect;
import com.heikes.rent_common.remote.house.CollectRemote;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin(origins = "*")
public class CollectController implements CollectRemote {
    @Resource
    private HouseCollectService houseCollectService;

    @Override
    public Bizdto<Integer> insert(HouseCollect houseCollect) {
        Bizdto<Integer> bizdto = new Bizdto<>();
        int count = houseCollectService.insert(houseCollect);
        if (count == 1){
            bizdto.setCode(StatusCode.OK);
            bizdto.setMessage("收藏成功");
            bizdto.setData(count);
        }else {
            bizdto.setCode(StatusCode.ERROR);
            bizdto.setMessage("收藏失败");
        }
        return bizdto;
    }
}
