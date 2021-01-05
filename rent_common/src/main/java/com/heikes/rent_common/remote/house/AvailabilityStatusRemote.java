package com.heikes.rent_common.remote.house;

import com.heikes.rent_common.dto.Bizdto;
import org.omg.CORBA.INTERNAL;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface AvailabilityStatusRemote {
    //添加
    @RequestMapping("/addStatus")
    Bizdto<Integer> addStatus(@RequestParam("startDate") String startDate,
                              @RequestParam("stopDate") String stopDate,
                              @RequestParam("houseId") Integer houseId);
    //删除
    @RequestMapping("/deleteStatus")
    Bizdto<Integer> deleteStatus(@RequestParam("id") Integer id);
    //查询
    @RequestMapping("/checkStatus")
    Bizdto<Integer> checkStatus(@RequestParam("startDate") String startDate,
                                @RequestParam("stopDate") String stopDate,
                                @RequestParam("hosueId") String hosueId);
}
