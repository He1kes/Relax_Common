package com.rent.user.consumer.hystrix;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.Role;
import com.heikes.rent_common.vo.PageResult;
import com.rent.user.consumer.client.RoleClient;
import feign.hystrix.FallbackFactory;

import java.util.List;
import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/11
 * @Time:10:02
 */
public class RoleClientFallback implements FallbackFactory<RoleClient> {
    @Override
    public RoleClient create(Throwable cause) {
        return new RoleClient() {
            @Override
            public Bizdto<List<Role>> selectRoles(Map<String, Object> map) {
                Bizdto<List<Role>> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage("远程接口调用错误");
                bizdto.setData(null);
                return bizdto;
            }

            @Override
            public Bizdto<PageResult<Role>> selectRoleByPage(Integer pageNum, Integer pageSize) {
                Bizdto<PageResult<Role>> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage("远程接口调用错误");
                bizdto.setData(null);
                return bizdto;
            }
        };
    }
}
