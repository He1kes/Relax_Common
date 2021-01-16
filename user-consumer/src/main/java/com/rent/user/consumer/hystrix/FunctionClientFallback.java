package com.rent.user.consumer.hystrix;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.Function;
import com.rent.user.consumer.client.FunctionClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/13
 * @Time:8:32
 */
@Component
public class FunctionClientFallback implements FallbackFactory<FunctionClient> {
    @Override
    public FunctionClient create(Throwable cause) {
        return new FunctionClient() {
            @Override
            public Bizdto<List<Function>> selectFunction(Map<String, Object> map) {
                Bizdto<List<Function>> bizdto = new Bizdto<>();
                bizdto.setMessage("请求失败");
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setData(null);
                return bizdto;
            }
        };
    }
}
