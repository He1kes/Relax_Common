package com.heikes.comment_provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.heikes.comment_provider.mapper")
public class CommentProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentProviderApplication.class, args);
	}

}
