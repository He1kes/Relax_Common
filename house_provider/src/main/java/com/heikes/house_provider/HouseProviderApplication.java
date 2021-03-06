package com.heikes.house_provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
@MapperScan(basePackages = "com.heikes.house_provider.mapper")
public class HouseProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(HouseProviderApplication.class, args);
	}

}
