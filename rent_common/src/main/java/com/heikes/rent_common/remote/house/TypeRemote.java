package com.heikes.rent_common.remote.house;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.HouseType;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/type/font/public")
public interface TypeRemote {
    //全部房屋类型
    @RequestMapping("/allHouseType")
    Bizdto<List<HouseType>> getAllHouseType();
}
