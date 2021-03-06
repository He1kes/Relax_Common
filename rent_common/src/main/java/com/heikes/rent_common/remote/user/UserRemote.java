package com.heikes.rent_common.remote.user;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.User;
import com.heikes.rent_common.pojo.Users;
import com.heikes.rent_common.vo.PageResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2020/12/29
 * @Time:15:22
 */
public interface UserRemote {

    @PostMapping(value = "addNormalUser")
    Bizdto<Boolean> addNormalUser(@RequestBody User user, @RequestParam(value = "roleId") Long roleId);

    @GetMapping(value = "selectUserImg")
    Bizdto<User> selectUserImg(@RequestParam(value = "userAccount") String userAccount);

    @GetMapping(value = "selectByLogin")
    Bizdto<User> selectByLogin(@RequestParam(value = "userAccount") String userAccount,
                               @RequestParam(value = "password") String password);

    @PostMapping(value = "selectUserByColumn")
    Bizdto<User> selectUserByColumn(@RequestBody Map<String, Object> columns);

    @PostMapping(value = "updateColumnById")
    Bizdto<Boolean> updateColumnById(@RequestBody Map<String, Object> map);

    @PostMapping(value = "selectUserListByColumn")
    Bizdto<PageResult<Users>> selectUserListByColumn(@RequestBody Map<String, Object> map);
}
