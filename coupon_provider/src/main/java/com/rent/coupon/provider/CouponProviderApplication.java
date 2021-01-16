package com.rent.coupon.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.rent.coupon.provider.mapper")
public class CouponProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponProviderApplication.class, args);
    }

}
