package com.heikes.rent_common.remote.house;


import com.github.pagehelper.PageInfo;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.CancelPolicy;
import com.heikes.rent_common.pojo.HouseInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/info")
public interface InfoRemote {

    //根据房源id查询房源
    @RequestMapping("/font/public/getHouseInfoById")
    public Bizdto<HouseInfo> getHouseInfoById(@RequestParam("id") Integer id);

    //新增房源
    @RequestMapping(value = "/back/addHouseInfo",method = RequestMethod.POST)
    public Bizdto<Integer> addHouseInfo(@RequestBody HouseInfo houseInfo);

    //修改修改房源
    @RequestMapping("/back/updateHouseInfo")
    public Bizdto<Integer> updateHouseInfo(@RequestBody HouseInfo houseInfo);

    //审核
    @RequestMapping("/back/HouseCheckPass")
    public Bizdto<Integer> HouseCheckPass(@RequestParam("id") Integer id);

    //下架
    @RequestMapping("/back/HouseCheckStop")
    public Bizdto<Integer> HouseCheckStop(@RequestParam("id") Integer id);

    //后台房源查询管理员
    @RequestMapping("/back/BackAdminAll")
    Bizdto<PageInfo<HouseInfo>> BackAdminall(@RequestParam("pageNum") Integer pageNum,
                                  @RequestParam("pageSize") Integer pageSize,
                                  @RequestParam(value = "userName",required = false) String userName,
                                  @RequestParam(value = "address",required = false) String address);

    //后台未审核房源查询管理员
    @RequestMapping("/back/BackAdminCheck")
    Bizdto<PageInfo<HouseInfo>> BackAdminCheck(@RequestParam("pageNum") Integer pageNum,
                                             @RequestParam("pageSize") Integer pageSize,
                                             @RequestParam(value = "userName",required = false) String userName,
                                             @RequestParam(value = "address",required = false) String address);

    //前台房源查询
    @RequestMapping("/font/public/FrontAll")
    Bizdto<PageInfo<HouseInfo>> Fontall(@RequestParam("pageNum") Integer pageNum,
                                        @RequestParam("pageSize") Integer pageSize,
                                        @RequestParam(value = "houseType",required = false) Integer houseType,
                                        @RequestParam(value = "area",required = false) Integer area,
                                        @RequestParam(value = "rent",required = false) Integer rent,
                                        @RequestParam(value = "address",required = false) String address);

    //后台查询房源商家
    @RequestMapping("/back/BackBussAll")
    Bizdto<PageInfo<HouseInfo>> BackBussall(@RequestParam("pageNum") Integer pageNum,
                                            @RequestParam("pageSize") Integer pageSize,
                                            @RequestParam(value = "address",required = false) String address,
                                            @RequestParam(value = "checkStatus",required = false) Integer checkStatus,
                                            @RequestParam("id") Long id);

    //通过活动请求
    @RequestMapping("/back/activePass")
    Bizdto<Integer> activePass(@RequestParam("id") Integer id);

    //根据id查询具体取消政策
    @RequestMapping("/font/public/cancel")
    Bizdto<CancelPolicy> cancel(@RequestParam("id") Integer id);
}
