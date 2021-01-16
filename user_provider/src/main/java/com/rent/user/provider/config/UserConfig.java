package com.rent.user.provider.config;

import com.heikes.rent_common.utils.AuthCodeUtil;
import com.heikes.rent_common.utils.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2020/12/29
 * @Time:15:59
 */
@Configuration
public class UserConfig {

    @Bean
    public IdWorker idWorker() {
        return new IdWorker();
    }
}
