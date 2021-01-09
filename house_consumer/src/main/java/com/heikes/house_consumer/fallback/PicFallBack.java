package com.heikes.house_consumer.fallback;

import com.heikes.house_consumer.client.PicClient;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.PicPath;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PicFallBack implements FallbackFactory<PicClient> {
    @Override
    public PicClient create(Throwable throwable) {
        return new PicClient() {

            @Override
            public Bizdto<Integer> insert(String path, Integer houseId) {
                Bizdto<Integer> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.ERROR);
                bizdto.setMessage(throwable.getMessage());
                return bizdto;
            }

            @Override
            public Bizdto<List<PicPath>> allPath(Integer houseId) {
                Bizdto<List<PicPath>> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.ERROR);
                bizdto.setMessage(throwable.getMessage());
                return bizdto;
            }
        };
    }
}
