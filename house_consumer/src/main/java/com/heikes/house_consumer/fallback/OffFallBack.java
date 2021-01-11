package com.heikes.house_consumer.fallback;

import com.heikes.house_consumer.client.OffClient;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.Off;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class OffFallBack implements FallbackFactory<OffClient> {
    @Override
    public OffClient create(Throwable throwable) {
        return new OffClient() {
            @Override
            public Bizdto<List<Off>> allOff() {
                Bizdto<List<Off>> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage(throwable.getMessage());
                return bizdto;
            }
        };
    }
}
