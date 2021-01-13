package com.heikes.rent_common.remote.user;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.Role;
import com.heikes.rent_common.vo.PageResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/11
 * @Time:10:00
 */
public interface RoleRemote {
    @PostMapping(value = "selectRoles")
    Bizdto<List<Role>> selectRoles(@RequestBody  Map<String, Object> map);

    @PostMapping(value = "selectRoleByPage")
    Bizdto<PageResult<Role>> selectRoleByPage(@RequestParam(value = "pageNum") Integer pageNum,
                                              @RequestParam(value = "pageSzie") Integer pageSize);
}
