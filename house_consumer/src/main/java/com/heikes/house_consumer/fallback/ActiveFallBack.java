package com.heikes.house_consumer.fallback;

import com.github.pagehelper.PageInfo;
import com.heikes.house_consumer.client.ActiveClient;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.ActivitiesCheck;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ActiveFallBack implements FallbackFactory<ActiveClient> {
    @Override
    public ActiveClient create(Throwable throwable) {
        return new ActiveClient() {
            @Override
            public Bizdto<Integer> insert(ActivitiesCheck activitiesCheck) {
                Bizdto<Integer> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage(throwable.getMessage());
                return bizdto;
            }

            @Override
            public Bizdto<PageInfo<ActivitiesCheck>> allActivitiesCheck(String offDetails) {
                Bizdto<PageInfo<ActivitiesCheck>> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage(throwable.getMessage());
                return bizdto;
            }
        };
    }
}
