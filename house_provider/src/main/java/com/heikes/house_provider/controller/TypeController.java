package com.heikes.house_provider.controller;

import com.heikes.house_provider.service.HouseTypeService;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.HouseType;
import com.heikes.rent_common.remote.house.TypeRemote;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TypeController implements TypeRemote {

    @Resource
    private HouseTypeService houseTypeService;

    @Override
    public Bizdto<List<HouseType>> getAllHouseType() {
        Bizdto<List<HouseType>> bizdto = new Bizdto<>();
        bizdto.setCode(StatusCode.OK);
        bizdto.setMessage("查询成功");
        bizdto.setData(houseTypeService.allType());
        return bizdto;
    }
}
