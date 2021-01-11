package com.heikes.rent_common.remote.house;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.PicPath;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/pic")
public interface PicPathRemote {
    //新增图片路径
    @RequestMapping("/back/pic/addPicPath")
    Bizdto<Integer> insert(@RequestParam("path") String path,
                           @RequestParam("houseId") Integer houseId);

    //根据房源id查询全部图片路径
    @RequestMapping("/font/public/pic/allPathById")
    Bizdto<List<PicPath>> allPath(@RequestParam("houseId") Integer houseId);
}
