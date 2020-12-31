package com.heikes.rent_common.remote.house;


import com.github.pagehelper.PageInfo;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.HouseInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface InfoRemote {

    //根据房源id查询房源
    @RequestMapping("/getHouseInfoById")
    public Bizdto<HouseInfo> getHouseInfoById(@RequestParam("id") Integer id);

    //新增房源
    @RequestMapping("/addHouseInfo")
    public Bizdto<Integer> addHouseInfo(@RequestBody HouseInfo houseInfo);

    //修改修改房源
    @RequestMapping("/updateHouseInfo")
    public Bizdto<Integer> updateHouseInfo(@RequestParam("id") Integer id,
                                           @RequestBody HouseInfo houseInfo);

    //审核
    @RequestMapping("HouseCheckPass")
    public Bizdto<Integer> HouseCheckPass(@RequestParam("id") Integer id);

    //下架
    @RequestMapping("HouseCheckStop")
    public Bizdto<Integer> HouseCheckStop(@RequestParam("id") Integer id);

    //后台房源查询管理员
    @RequestMapping("/BackAdminall")
    Bizdto<PageInfo<HouseInfo>> BackAdminall(@RequestParam("userName") String userName,
                                  @RequestParam("address") String address);

    //前台房源查询
    @RequestMapping("/Fontall")
    Bizdto<PageInfo<HouseInfo>> Fontall(@RequestParam("houseType") Integer houseType,
                                        @RequestParam("area") Integer area,
                                        @RequestParam("rent") Integer rent,
                                        @RequestParam("address") String address);

    //后台查询房源商家
    @RequestMapping("/BackBussall")
    Bizdto<PageInfo<HouseInfo>> BackBussall(@RequestParam("address") String address,
                                            @RequestParam("checkStatus") Integer checkStatus);

    //通过活动请求
    @RequestMapping("activePass")
    Bizdto<Integer> activePass(@RequestParam("id") Integer id);
}
