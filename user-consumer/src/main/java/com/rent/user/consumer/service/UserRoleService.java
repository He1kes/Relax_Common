package com.rent.user.consumer.service;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.UserRole;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/6
 * @Time:20:06
 */
public interface UserRoleService {

    Bizdto<UserRole> findByColumn(Map<String, Object> map);
}
