package com.rent.order_consumer.fallback;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.rent.order_consumer.client.AvailabilityStatusClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class AvailabilityStatusFallBack implements FallbackFactory<AvailabilityStatusClient> {
    @Override
    public AvailabilityStatusClient create(Throwable throwable) {
        return new AvailabilityStatusClient() {
            @Override
            public Bizdto<Integer> addStatus(String startDate, String stopDate, Integer houseId) {
                Bizdto<Integer> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage("熔断，addStatus发生错误。");
                return bizdto;
            }

            @Override
            public Bizdto<Integer> deleteStatus(Integer id) {
                Bizdto<Integer> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage("熔断，deleteStatus发生错误。");
                return bizdto;
            }

            @Override
            public Bizdto<Integer> checkStatus(String startDate, String stopDate, Integer houseId) {
                Bizdto<Integer> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage("熔断，checkStatus发生错误。");
                return bizdto;
            }
        };
    }
}
