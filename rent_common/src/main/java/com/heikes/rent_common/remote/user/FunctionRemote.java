package com.heikes.rent_common.remote.user;

import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.Function;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/13
 * @Time:8:24
 */
public interface FunctionRemote {

    @PostMapping(value = "/selectFunction")
    public Bizdto<List<Function>> selectFunction(@RequestBody Map<String, Object> map);
}
