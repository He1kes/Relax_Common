package com.rent.order_consumer.client;

import com.heikes.rent_common.remote.house.PicPathRemote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name = "house-provider")
public interface PicPathClient extends PicPathRemote {
}
