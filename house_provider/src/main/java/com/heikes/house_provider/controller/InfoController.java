package com.heikes.house_provider.controller;

import com.github.pagehelper.PageInfo;
import com.heikes.house_provider.service.FileService;
import com.heikes.house_provider.service.HouseInfoService;
import com.heikes.house_provider.service.PicPathService;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.CancelPolicy;
import com.heikes.rent_common.pojo.HouseInfo;
import com.heikes.rent_common.remote.house.InfoRemote;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin(origins = "*")
public class InfoController implements InfoRemote {
    @Resource
    private HouseInfoService houseInfoService;

    @Resource
    private FileService fileService;

    @Resource
    private PicPathService picPathService;

    @Override
    public Bizdto<HouseInfo> getHouseInfoById(Integer id) {
        Bizdto<HouseInfo> bizdto = new Bizdto<>();
        bizdto.setCode(StatusCode.OK);
        bizdto.setMessage("查询成功");
        bizdto.setData(houseInfoService.selectByPrimaryKey(id));
        return bizdto;
    }

    @Override
    public Bizdto<Integer> addHouseInfo(HouseInfo houseInfo) {
        Bizdto<Integer> bizdto = new Bizdto<>();
        houseInfoService.insert(houseInfo);
        int id = houseInfo.getId();
        if (id > 0){
            bizdto.setCode(StatusCode.OK);
            bizdto.setMessage("新增成功");
            bizdto.setData(id);
        }else {
            bizdto.setCode(StatusCode.ERROR);
            bizdto.setMessage("新增失败");
        }
        return bizdto;
    }

    @Override
    public Bizdto<Integer> updateHouseInfo(HouseInfo houseInfo) {
        Bizdto<Integer> bizdto = new Bizdto<>();
        int count = houseInfoService.updateByPrimaryKey(houseInfo);
        if (count == 1){
            bizdto.setCode(StatusCode.OK);
            bizdto.setMessage("修改成功");
            bizdto.setData(count);
        }else {
            bizdto.setCode(StatusCode.ERROR);
            bizdto.setMessage("修改失败");
        }
        return bizdto;
    }

    @Override
    public Bizdto<Integer> HouseCheckPass(Integer id) {
        Bizdto<Integer> bizdto = new Bizdto<>();
        int count = houseInfoService.checkPass(id);
        if (count == 1){
            bizdto.setCode(StatusCode.OK);
            bizdto.setMessage("审核成功");
            bizdto.setData(count);
        }else {
            bizdto.setCode(StatusCode.ERROR);
            bizdto.setMessage("审核失败");
        }
        return bizdto;
    }

    @Override
    public Bizdto<Integer> HouseCheckStop(Integer id) {
        Bizdto<Integer> bizdto = new Bizdto<>();
        int count = houseInfoService.checkStop(id);
        if (count == 1){
            bizdto.setCode(StatusCode.OK);
            bizdto.setMessage("下架成功");
            bizdto.setData(count);
        }else {
            bizdto.setCode(StatusCode.ERROR);
            bizdto.setMessage("下架失败");
        }
        return bizdto;
    }

    @Override
    public Bizdto<PageInfo<HouseInfo>> BackAdminall(Integer pageNum, Integer pageSize, String userName, String address) {
        Bizdto<PageInfo<HouseInfo>> bizdto = new Bizdto<>();
        bizdto.setCode(StatusCode.OK);
        bizdto.setMessage("查询成功");
        bizdto.setData(houseInfoService.BackAdminall(pageNum,pageSize,userName,address));
        return bizdto;
    }

    @Override
    public Bizdto<PageInfo<HouseInfo>> BackAdminCheck(Integer pageNum, Integer pageSize, String userName, String address) {
        Bizdto<PageInfo<HouseInfo>> bizdto = new Bizdto<>();
        bizdto.setCode(StatusCode.OK);
        bizdto.setMessage("查询成功");
        bizdto.setData(houseInfoService.BackAdminallCheck(pageNum,pageSize,userName,address));
        return bizdto;
    }

    @Override
    public Bizdto<PageInfo<HouseInfo>> Fontall(Integer pageNum, Integer pageSize, Integer houseType, Integer area, Integer rent, String address) {
        Bizdto<PageInfo<HouseInfo>> bizdto = new Bizdto<>();
        bizdto.setCode(StatusCode.OK);
        bizdto.setMessage("查询成功");
        bizdto.setData(houseInfoService.Fontall(pageNum,pageSize,houseType,area,rent,address));
        return bizdto;
    }

    @Override
    public Bizdto<PageInfo<HouseInfo>> BackBussall(Integer pageNum, Integer pageSize, String address, Integer checkStatus,Long id) {
        Bizdto<PageInfo<HouseInfo>> bizdto = new Bizdto<>();
        bizdto.setCode(StatusCode.OK);
        bizdto.setMessage("查询成功");
        bizdto.setData(houseInfoService.BackBussall(pageNum,pageSize,address,checkStatus,id));
        return bizdto;
    }

    @Override
    public Bizdto<Integer> activePass(Integer id) {
        Bizdto<Integer> bizdto = new Bizdto<>();
        int count = houseInfoService.activePass(id);
        if (count == 1){
            bizdto.setCode(StatusCode.OK);
            bizdto.setMessage("通过成功");
            bizdto.setData(count);
        }else {
            bizdto.setCode(StatusCode.ERROR);
            bizdto.setMessage("通过失败");
        }
        return bizdto;
    }

    @Override
    public Bizdto<CancelPolicy> cancel(Integer id) {
        Bizdto<CancelPolicy> bizdto = new Bizdto<>();
        bizdto.setCode(StatusCode.OK);
        bizdto.setMessage("查询成功");
        bizdto.setData(houseInfoService.Cancel(id));
        return bizdto;
    }
}
