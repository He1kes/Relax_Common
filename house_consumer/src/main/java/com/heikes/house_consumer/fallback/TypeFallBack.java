package com.heikes.house_consumer.fallback;

import com.heikes.house_consumer.client.TypeClient;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.HouseType;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TypeFallBack implements FallbackFactory<TypeClient> {
    @Override
    public TypeClient create(Throwable throwable) {
        return new TypeClient() {
            @Override
            public Bizdto<List<HouseType>> getAllHouseType() {
                Bizdto<List<HouseType>> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage(throwable.getMessage());
                return bizdto;
            }
        };
    }
}
