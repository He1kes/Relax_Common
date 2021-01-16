package com.rent.order_consumer.client;

import com.heikes.rent_common.remote.house.TypeRemote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name = "house-provider")
public interface TypeClient extends TypeRemote {
}
