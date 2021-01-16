package com.rent.user.consumer.config;

import com.heikes.rent_common.utils.AuthCodeUtil;
import com.rent.user.consumer.utils.FileUploadUtil;
import com.rent.user.consumer.utils.PhoneCodeUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2020/12/30
 * @Time:15:40
 */
@Configuration
public class UserConfig {

    @Bean
    public FileUploadUtil fileUploadUtil() {
        return new FileUploadUtil();
    }

    @Bean
    public AuthCodeUtil authCodeUtil() {
        return new AuthCodeUtil();
    }

    @Bean
    public PhoneCodeUtil phoneCodeUtil() {
        return new PhoneCodeUtil();
    }
}
