package com.heikes.house_consumer.controller;

import com.github.pagehelper.PageInfo;
import com.heikes.house_consumer.service.FileService;
import com.heikes.house_consumer.service.InfoService;
import com.heikes.house_consumer.service.PicpathService;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.CancelPolicy;
import com.heikes.rent_common.pojo.HouseInfo;
import com.heikes.rent_common.vo.ResultVo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/consumer/info")
public class InfoController {
    @Resource
    private InfoService infoService;

    @Resource
    private FileService fileService;

    @Resource
    private PicpathService picpathService;

    //根据房源id查询房源
    @RequestMapping("/getHouseInfoById")
    public ResultVo<HouseInfo> getHouseInfoById(@RequestParam("id") Integer id){
        Bizdto<HouseInfo> bizdto = infoService.selectByPrimaryKey(id);
        boolean flag = false;
        if (bizdto.getData() != null){
            flag = true;
            return new ResultVo<>(flag, StatusCode.OK,bizdto.getMessage(), bizdto.getData());
        }
        return new ResultVo<>(flag, bizdto.getCode(),bizdto.getMessage(), bizdto.getData());
    }

    //新增房源
    @RequestMapping(value = "/back/addHouseInfo",method = RequestMethod.POST)
    public ResultVo<Integer> addHouseInfo(HouseInfo houseInfo,
                                          @RequestParam("files") MultipartFile[] files,
                                          @RequestParam("module") String module){
        Bizdto<Integer> bizdto = infoService.insert(houseInfo);
        boolean flag = false;
        if (bizdto.getData() != null){
            for (MultipartFile file : files) {
                try {
                    InputStream inputStream = file.getInputStream();
                    String originalFilename = file.getOriginalFilename();
                    String fileURL = fileService.upload(inputStream, module, originalFilename);
                    picpathService.insert(fileURL, bizdto.getData());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            flag = true;
            return new ResultVo<>(flag, StatusCode.OK,bizdto.getMessage(), bizdto.getData());
        }
        return new ResultVo<>(flag, bizdto.getCode(),bizdto.getMessage(), bizdto.getData());
    }

    //修改修改房源
    @RequestMapping("/back/updateHouseInfo")
    public ResultVo<Integer> updateHouseInfo(@RequestBody HouseInfo houseInfo){
        Bizdto<Integer> bizdto = infoService.updateByPrimaryKey(houseInfo);
        boolean flag = false;
        if (bizdto.getData() == 1){
            flag = true;
            return new ResultVo<>(flag, StatusCode.OK,bizdto.getMessage(), bizdto.getData());
        }
        return new ResultVo<>(flag, bizdto.getCode(),bizdto.getMessage(), bizdto.getData());
    }

    //审核
    @RequestMapping("/back/HouseCheckPass")
    public ResultVo<Integer> HouseCheckPass(@RequestParam("id") Integer id){
        Bizdto<Integer> bizdto = infoService.checkPass(id);
        boolean flag = false;
        if (bizdto.getData() == 1){
            flag = true;
            return new ResultVo<>(flag, StatusCode.OK,bizdto.getMessage(), bizdto.getData());
        }
        return new ResultVo<>(flag, bizdto.getCode(),bizdto.getMessage(), bizdto.getData());
    }

    //下架
    @RequestMapping("/back/HouseCheckStop")
    public ResultVo<Integer> HouseCheckStop(@RequestParam("id") Integer id){
        Bizdto<Integer> bizdto = infoService.checkStop(id);
        boolean flag = false;
        if (bizdto.getData() == 1){
            flag = true;
            return new ResultVo<>(flag, StatusCode.OK,bizdto.getMessage(), bizdto.getData());
        }
        return new ResultVo<>(flag, bizdto.getCode(),bizdto.getMessage(), bizdto.getData());
    }

    //后台房源查询管理员
    @RequestMapping("/back/BackAdminAll")
    ResultVo<PageInfo<HouseInfo>> BackAdminall(@RequestParam("pageNum") Integer pageNum,
                                             @RequestParam("pageSize") Integer pageSize,
                                             @RequestParam("userName") String userName,
                                             @RequestParam("address") String address){
        Bizdto<PageInfo<HouseInfo>> bizdto = infoService.BackAdminall(pageNum, pageSize, userName, address);
        boolean flag = false;
        if (bizdto.getData() != null){
            flag = true;
            return new ResultVo<>(flag, StatusCode.OK,bizdto.getMessage(), bizdto.getData());
        }
        return new ResultVo<>(flag, bizdto.getCode(),bizdto.getMessage(), bizdto.getData());
    }

    //后台未审核房源查询管理员
    @RequestMapping("/back/BackAdminCheck")
    ResultVo<PageInfo<HouseInfo>> BackAdminCheck(@RequestParam("pageNum") Integer pageNum,
                                               @RequestParam("pageSize") Integer pageSize,
                                               @RequestParam(value = "userName",required = false) String userName,
                                               @RequestParam(value = "address",required = false) String address){
        Bizdto<PageInfo<HouseInfo>> bizdto = infoService.BackAdminallCheck(pageNum, pageSize, userName, address);
        boolean flag = false;
        if (bizdto.getData() != null){
            flag = true;
            return new ResultVo<>(flag, StatusCode.OK,bizdto.getMessage(), bizdto.getData());
        }
        return new ResultVo<>(flag, bizdto.getCode(),bizdto.getMessage(), bizdto.getData());
    }

    //前台房源查询
    @RequestMapping("/font/public/FrontAll")
    ResultVo<PageInfo<HouseInfo>> Fontall(@RequestParam("pageNum") Integer pageNum,
                                        @RequestParam("pageSize") Integer pageSize,
                                        @RequestParam("houseType") Integer houseType,
                                        @RequestParam("area") Integer area,
                                        @RequestParam("rent") Integer rent,
                                        @RequestParam("address") String address){
        Bizdto<PageInfo<HouseInfo>> bizdto = infoService.Fontall(pageNum, pageSize, houseType, area, rent, address);
        boolean flag = false;
        if (bizdto.getData() != null){
            flag = true;
            return new ResultVo<>(flag, StatusCode.OK,bizdto.getMessage(), bizdto.getData());
        }
        return new ResultVo<>(flag, bizdto.getCode(),bizdto.getMessage(), bizdto.getData());
    }

    //后台查询房源商家
    @RequestMapping("/back/BackBussAll")
    ResultVo<PageInfo<HouseInfo>> BackBussall(@RequestParam("pageNum") Integer pageNum,
                                            @RequestParam("pageSize") Integer pageSize,
                                            @RequestParam(value = "address",required = false) String address,
                                            @RequestParam(value = "checkStatus",required = false) Integer checkStatus,
                                            @RequestParam("id") Long id){
        Bizdto<PageInfo<HouseInfo>> bizdto = infoService.BackBussall(pageNum, pageSize, address, checkStatus,id);
        boolean flag = false;
        if (bizdto.getData() != null){
            flag = true;
            return new ResultVo<>(flag, StatusCode.OK,bizdto.getMessage(), bizdto.getData());
        }
        return new ResultVo<>(flag, bizdto.getCode(),bizdto.getMessage(), bizdto.getData());
    }

    //通过活动请求
    @RequestMapping("/back/activePass")
    ResultVo<Integer> activePass(@RequestParam("id") Integer id){
        Bizdto<Integer> bizdto = infoService.activePass(id);
        boolean flag = false;
        if (bizdto.getData() == 1){
            flag = true;
            return new ResultVo<>(flag, StatusCode.OK,bizdto.getMessage(), bizdto.getData());
        }
        return new ResultVo<>(flag, bizdto.getCode(),bizdto.getMessage(), bizdto.getData());
    }

    //根据id查询具体取消政策
    @RequestMapping("/font/public/cancel")
    ResultVo<CancelPolicy> cancel(@RequestParam("id") Integer id){
        Bizdto<CancelPolicy> bizdto = infoService.Cancel(id);
        boolean flag = false;
        if (bizdto.getData() != null){
            flag = true;
            return new ResultVo<>(flag, StatusCode.OK,bizdto.getMessage(), bizdto.getData());
        }
        return new ResultVo<>(flag, bizdto.getCode(),bizdto.getMessage(), bizdto.getData());
    }
}
