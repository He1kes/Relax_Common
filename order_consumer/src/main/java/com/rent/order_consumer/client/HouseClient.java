package com.rent.order_consumer.client;

import com.heikes.rent_common.remote.house.InfoRemote;
import com.rent.order_consumer.fallback.AvailabilityStatusFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name = "house-provider")
public interface HouseClient extends InfoRemote {
}
