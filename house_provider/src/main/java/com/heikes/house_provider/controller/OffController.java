package com.heikes.house_provider.controller;

import com.heikes.house_provider.service.OffService;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.Off;
import com.heikes.rent_common.remote.house.OffRemote;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class OffController implements OffRemote {
    @Resource
    private OffService offService;

    @Override
    public Bizdto<List<Off>> allOff() {
        Bizdto<List<Off>> bizdto = new Bizdto<>();
        bizdto.setCode(StatusCode.OK);
        bizdto.setMessage("查询成功");
        bizdto.setData(offService.offAll());
        return bizdto;
    }
}
