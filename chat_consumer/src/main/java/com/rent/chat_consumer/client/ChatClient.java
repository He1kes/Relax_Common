package com.rent.chat_consumer.client;

import com.heikes.rent_common.remote.chat.ChatRemote;
import com.rent.chat_consumer.fallback.ChatFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name = "chat-provider",fallbackFactory = ChatFallBack.class)
public interface ChatClient extends ChatRemote {
}
