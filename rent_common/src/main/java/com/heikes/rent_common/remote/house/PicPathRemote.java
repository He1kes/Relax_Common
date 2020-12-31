package com.heikes.rent_common.remote.house;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.PicPath;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PicPathRemote {
    //新增图片路径
    @RequestMapping("/addPicPath")
    Bizdto<Integer> insert(PicPath picPath);

    //根据房源id查询全部图片路径
    @RequestMapping("/allPathById")
    Bizdto<List<PicPath>> allPath(@RequestParam("houseId") Integer houseId);
}
