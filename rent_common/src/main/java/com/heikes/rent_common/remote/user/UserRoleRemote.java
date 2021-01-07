package com.heikes.rent_common.remote.user;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.UserRole;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/6
 * @Time:19:33
 */
public interface UserRoleRemote {

    @PostMapping(value = "selectByColumn")
    Bizdto<UserRole> selectByColumn(@RequestBody Map<String, Object> map);
}
