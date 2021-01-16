package com.rent.chat_consumer;

import com.heikes.rent_common.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ChatConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatConsumerApplication.class, args);
    }

}
