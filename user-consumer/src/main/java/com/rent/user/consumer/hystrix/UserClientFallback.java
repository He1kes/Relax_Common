package com.rent.user.consumer.hystrix;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.User;
import com.heikes.rent_common.pojo.Users;
import com.heikes.rent_common.vo.PageResult;
import com.rent.user.consumer.client.UserClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2020/12/30
 * @Time:11:29
 */
@Component
public class UserClientFallback implements FallbackFactory<UserClient> {
    @Override
    public UserClient create(Throwable cause) {
        UserClient userClient = new UserClient() {
            @Override
            public Bizdto<Boolean> addNormalUser(User user, Long roleId) {
                Bizdto<Boolean> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage(cause.getMessage());
                bizdto.setData(null);
                return bizdto;
            }

            @Override
            public Bizdto<User> selectUserImg(String userAccount) {
                Bizdto<User> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage(cause.getMessage());
                bizdto.setData(null);
                return bizdto;
            }

            @Override
            public Bizdto<User> selectByLogin(String userAccount, String password) {
                Bizdto<User> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage(cause.getMessage());
                bizdto.setData(null);
                return bizdto;
            }

            @Override
            public Bizdto<User> selectUserByColumn(Map<String, Object> columns) {
                Bizdto<User> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage(cause.getMessage());
                bizdto.setData(null);
                return bizdto;
            }

            @Override
            public Bizdto<Boolean> updateColumnById(Map<String, Object> map) {
                Bizdto<Boolean> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage(cause.getMessage());
                bizdto.setData(null);
                return bizdto;
            }

            @Override
            public Bizdto<PageResult<Users>> selectUserListByColumn(Map<String, Object> map) {
                Bizdto<PageResult<Users>> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage(cause.getMessage());
                bizdto.setData(null);
                return bizdto;
            }
        };
        return userClient;
    }
}
