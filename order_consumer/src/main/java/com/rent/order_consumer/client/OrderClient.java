package com.rent.order_consumer.client;

import com.heikes.rent_common.remote.order.OrderRemote;
import com.rent.order_consumer.fallback.OrderFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name = "order-provider",fallbackFactory = OrderFallBack.class)
public interface OrderClient extends OrderRemote {
}
