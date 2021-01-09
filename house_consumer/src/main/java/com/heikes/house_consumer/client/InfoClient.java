package com.heikes.house_consumer.client;

import com.heikes.house_consumer.fallback.InfoFallBack;
import com.heikes.rent_common.remote.house.InfoRemote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(name = "house-provider",fallbackFactory = InfoFallBack.class)
@Component
public interface InfoClient extends InfoRemote {
}
