package com.heikes.rent_common.remote.house;

import com.github.pagehelper.PageInfo;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.ActivitiesCheck;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/active/back")
public interface ActivitiesCheckRemote {

    //发出促销请求
    @RequestMapping("/addActivitiesCheck")
    Bizdto<Integer> insert(@RequestBody ActivitiesCheck activitiesCheck);

    //查询全部商户促销
    @RequestMapping("/allActivitiesCheck")
    Bizdto<PageInfo<ActivitiesCheck>> allActivitiesCheck(@RequestParam(value = "offDetails",required = false) String offDetails);
}
