package com.heikes.house_provider.controller;

import com.heikes.house_provider.service.PicPathService;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.PicPath;
import com.heikes.rent_common.remote.house.PicPathRemote;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PicPathController implements PicPathRemote {
    @Resource
    private PicPathService picPathService;

    @Override
    public Bizdto<Integer> insert(String path,Integer houseId) {
        Bizdto<Integer> bizdto = new Bizdto<>();
        int count = picPathService.insert(path, houseId);
        if (count == 1){
            bizdto.setCode(StatusCode.OK);
            bizdto.setMessage("插入成功");
        }else {
            bizdto.setCode(StatusCode.ERROR);
            bizdto.setMessage("插入失败");
        }
        return bizdto;
    }

    @Override
    public Bizdto<List<PicPath>> allPath(Integer houseId) {
        Bizdto<List<PicPath>> bizdto = new Bizdto<>();
        bizdto.setCode(StatusCode.OK);
        bizdto.setMessage("查询成功");
        bizdto.setData(picPathService.allPath(houseId));
        return bizdto;
    }
}
