package com.heikes.house_consumer.client;

import com.heikes.house_consumer.fallback.OffFallBack;
import com.heikes.rent_common.remote.house.OffRemote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(name = "house-provider",fallbackFactory = OffFallBack.class)
@Component
public interface OffClient extends OffRemote {
}
