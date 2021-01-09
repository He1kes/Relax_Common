package com.heikes.house_consumer.client;

import com.heikes.house_consumer.fallback.ActiveFallBack;
import com.heikes.rent_common.remote.house.ActivitiesCheckRemote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(name = "house-provider",fallbackFactory = ActiveFallBack.class)
@Component
public interface ActiveClient extends ActivitiesCheckRemote {
}
