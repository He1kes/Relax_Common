package com.heikes.house_consumer.client;

import com.heikes.house_consumer.fallback.TypeFallBack;
import com.heikes.rent_common.remote.house.TypeRemote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(name = "house-provider",fallbackFactory = TypeFallBack.class)
@Component
public interface TypeClient extends TypeRemote {
}
