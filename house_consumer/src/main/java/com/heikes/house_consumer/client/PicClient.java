package com.heikes.house_consumer.client;

import com.heikes.house_consumer.fallback.PicFallBack;
import com.heikes.rent_common.remote.house.PicPathRemote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(name = "house-provider",fallbackFactory = PicFallBack.class)
@Component
public interface PicClient extends PicPathRemote {
}
