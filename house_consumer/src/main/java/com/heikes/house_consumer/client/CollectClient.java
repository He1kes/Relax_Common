package com.heikes.house_consumer.client;

import com.heikes.house_consumer.fallback.CollectFallBack;
import com.heikes.rent_common.remote.house.CollectRemote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(name = "house-provider",fallbackFactory = CollectFallBack.class)
@Component
public interface CollectClient extends CollectRemote {
}
