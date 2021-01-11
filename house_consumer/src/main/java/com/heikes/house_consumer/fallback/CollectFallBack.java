package com.heikes.house_consumer.fallback;

import com.heikes.house_consumer.client.CollectClient;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.HouseCollect;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class CollectFallBack implements FallbackFactory<CollectClient> {
    @Override
    public CollectClient create(Throwable throwable) {
        return new CollectClient() {
            @Override
            public Bizdto<Integer> insert(HouseCollect houseCollect) {
                Bizdto<Integer> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage(throwable.getMessage());
                return bizdto;
            }
        };
    }
}
