package com.heikes.rent_common.remote.house;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.HouseCollect;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

public interface CollectRemote {

    //添加心愿单
    @RequestMapping("/addCollect")
    Bizdto<Integer> insert(@RequestBody HouseCollect houseCollect);
}
