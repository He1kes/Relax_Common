package com.heikes.rent_common.remote.house;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.Off;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface OffRemote {
    //查询全部活动政策
    @RequestMapping("/allOff")
    Bizdto<List<Off>> allOff();
}
