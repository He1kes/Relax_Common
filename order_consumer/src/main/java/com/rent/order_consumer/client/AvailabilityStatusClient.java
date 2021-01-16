package com.rent.order_consumer.client;

import com.heikes.rent_common.remote.order.AvailabilityStatusRemote;
import com.rent.order_consumer.fallback.AvailabilityStatusFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name = "order-provider",fallbackFactory = AvailabilityStatusFallBack.class)
public interface AvailabilityStatusClient extends AvailabilityStatusRemote {
}
