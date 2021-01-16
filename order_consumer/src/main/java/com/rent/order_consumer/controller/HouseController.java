package com.rent.order_consumer.controller;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.HouseInfo;
import com.heikes.rent_common.pojo.HouseType;
import com.heikes.rent_common.pojo.PicPath;
import com.heikes.rent_common.vo.ResultVo;
import com.rent.order_consumer.client.HouseClient;
import com.rent.order_consumer.client.PicPathClient;
import com.rent.order_consumer.client.TypeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ohouse")
public class HouseController {
    @Autowired
    private HouseClient houseClient;
    @Autowired
    private TypeClient typeClient;
    @Autowired
    private PicPathClient picPathClient;

    //通过房屋id获取房源信息
    @RequestMapping("/front/public/getHouseInfo")
    public ResultVo<HouseInfo> getHouseInfo(@RequestParam("id") Integer id){
        Bizdto<HouseInfo> bizdto = houseClient.getHouseInfoById(id);
        ResultVo<HouseInfo> resultVo = new ResultVo<>();
        if(bizdto.getData() != null){
            resultVo.setFlag(true);
            resultVo.setData(bizdto.getData());
        }else {
            resultVo.setFlag(false);
            resultVo.setMessage("getHouseInfo获取数据出错！ord-cos-c");
        }
        return resultVo;
    }

    //全部房屋类型
    @RequestMapping("/front/public/allHouseType")
    ResultVo<List<HouseType>> getAllHouseType(){
        Bizdto<List<HouseType>> bizdto = typeClient.getAllHouseType();
        ResultVo<List<HouseType>> resultVo = new ResultVo<>();
        if(bizdto.getData() != null){
            resultVo.setFlag(true);
            resultVo.setData(bizdto.getData());
        }else {
            resultVo.setFlag(false);
            resultVo.setMessage("allHouseType获取数据出错！ord-cos-c");
        }
        return resultVo;
    }

    //根据房源id查询全部图片路径
    @RequestMapping("/front/public/allPathById")
    ResultVo<List<PicPath>> allPath(@RequestParam("houseId") Integer houseId){
        ResultVo<List<PicPath>> resultVo = new ResultVo<>();
        Bizdto<List<PicPath>> bizdto = picPathClient.allPath(houseId);
        if(bizdto.getData() != null){
            resultVo.setFlag(true);
            resultVo.setData(bizdto.getData());
        }else {
            resultVo.setFlag(false);
            resultVo.setMessage("allPath获取数据出错！ord-cos-c");
        }
        return resultVo;
    }
}
