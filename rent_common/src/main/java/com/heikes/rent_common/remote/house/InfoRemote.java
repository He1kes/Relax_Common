package com.heikes.rent_common.remote.house;


import com.github.pagehelper.PageInfo;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.CancelPolicy;
import com.heikes.rent_common.pojo.HouseInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface InfoRemote {

    //根据房源id查询房源
    @RequestMapping("/info/getHouseInfoById")
    public Bizdto<HouseInfo> getHouseInfoById(@RequestParam("id") Integer id);

    //新增房源
    @RequestMapping("/info/addHouseInfo")
    public Bizdto<Integer> addHouseInfo(@RequestBody HouseInfo houseInfo);

    //修改修改房源
    @RequestMapping("/info/updateHouseInfo")
    public Bizdto<Integer> updateHouseInfo(@RequestBody HouseInfo houseInfo);

    //审核
    @RequestMapping("/info/HouseCheckPass")
    public Bizdto<Integer> HouseCheckPass(@RequestParam("id") Integer id);

    //下架
    @RequestMapping("/info/HouseCheckStop")
    public Bizdto<Integer> HouseCheckStop(@RequestParam("id") Integer id);

    //后台房源查询管理员
    @RequestMapping("/info/BackAdminAll")
    Bizdto<PageInfo<HouseInfo>> BackAdminall(@RequestParam("pageNum") Integer pageNum,
                                  @RequestParam("pageSize") Integer pageSize,
                                  @RequestParam("userName") String userName,
                                  @RequestParam("address") String address);

    //后台房源查询管理员
    @RequestMapping("/info/BackAdminCheck")
    Bizdto<PageInfo<HouseInfo>> BackAdminCheck(@RequestParam("pageNum") Integer pageNum,
                                             @RequestParam("pageSize") Integer pageSize,
                                             @RequestParam("userName") String userName,
                                             @RequestParam("address") String address);

    //前台房源查询
    @RequestMapping("/info/FrontAll")
    Bizdto<PageInfo<HouseInfo>> Fontall(@RequestParam("pageNum") Integer pageNum,
                                        @RequestParam("pageSize") Integer pageSize,
                                        @RequestParam("houseType") Integer houseType,
                                        @RequestParam("area") Integer area,
                                        @RequestParam("rent") Integer rent,
                                        @RequestParam("address") String address);

    //后台查询房源商家
    @RequestMapping("/info/BackBussall")
    Bizdto<PageInfo<HouseInfo>> BackBussall(@RequestParam("pageNum") Integer pageNum,
                                            @RequestParam("pageSize") Integer pageSize,
                                            @RequestParam("address") String address,
                                            @RequestParam("checkStatus") Integer checkStatus);

    //通过活动请求
    @RequestMapping("/info/activePass")
    Bizdto<Integer> activePass(@RequestParam("id") Integer id);

    //根据id查询具体取消政策
    @RequestMapping("/info/cancel")
    Bizdto<CancelPolicy> cancel(@RequestParam("id") Integer id);
}
