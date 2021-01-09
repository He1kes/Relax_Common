package com.heikes.house_consumer.fallback;

import com.github.pagehelper.PageInfo;
import com.heikes.house_consumer.client.InfoClient;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.CancelPolicy;
import com.heikes.rent_common.pojo.HouseInfo;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class InfoFallBack implements FallbackFactory<InfoClient> {

    @Override
    public InfoClient create(Throwable throwable) {
        return new InfoClient() {
            @Override
            public Bizdto<HouseInfo> getHouseInfoById(Integer id) {
                Bizdto<HouseInfo> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage(throwable.getMessage());
                return bizdto;
            }

            @Override
            public Bizdto<Integer> addHouseInfo(HouseInfo houseInfo) {
                Bizdto<Integer> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage(throwable.getMessage());
                return bizdto;
            }


            @Override
            public Bizdto<Integer> updateHouseInfo(HouseInfo houseInfo) {
                Bizdto<Integer> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage(throwable.getMessage());
                return bizdto;
            }

            @Override
            public Bizdto<Integer> HouseCheckPass(Integer id) {
                Bizdto<Integer> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage(throwable.getMessage());
                return bizdto;
            }

            @Override
            public Bizdto<Integer> HouseCheckStop(Integer id) {
                Bizdto<Integer> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage(throwable.getMessage());
                return bizdto;
            }

            @Override
            public Bizdto<PageInfo<HouseInfo>> BackAdminall(Integer pageNum, Integer pageSize, String userName, String address) {
                Bizdto<PageInfo<HouseInfo>> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage(throwable.getMessage());
                return bizdto;
            }

            @Override
            public Bizdto<PageInfo<HouseInfo>> BackAdminCheck(Integer pageNum, Integer pageSize, String userName, String address) {
                Bizdto<PageInfo<HouseInfo>> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage(throwable.getMessage());
                return bizdto;
            }

            @Override
            public Bizdto<PageInfo<HouseInfo>> Fontall(Integer pageNum, Integer pageSize, Integer houseType, Integer area, Integer rent, String address) {
                Bizdto<PageInfo<HouseInfo>> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage(throwable.getMessage());
                return bizdto;
            }

            @Override
            public Bizdto<PageInfo<HouseInfo>> BackBussall(Integer pageNum, Integer pageSize, String address, Integer checkStatus) {
                Bizdto<PageInfo<HouseInfo>> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage(throwable.getMessage());
                return bizdto;
            }

            @Override
            public Bizdto<Integer> activePass(Integer id) {
                Bizdto<Integer> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage(throwable.getMessage());
                return bizdto;
            }

            @Override
            public Bizdto<CancelPolicy> cancel(Integer id) {
                Bizdto<CancelPolicy> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage(throwable.getMessage());
                return bizdto;
            }
        };
    }
}
