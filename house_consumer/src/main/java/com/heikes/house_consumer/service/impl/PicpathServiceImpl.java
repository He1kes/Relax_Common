package com.heikes.house_consumer.service.impl;

import com.heikes.house_consumer.client.PicClient;
import com.heikes.house_consumer.service.PicpathService;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.PicPath;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PicpathServiceImpl implements PicpathService {
    @Resource
    private PicClient picClient;

    @Override
    public Bizdto<Integer> insert(String path, Integer houseId) {
        PicPath picPath = new PicPath();
        picPath.setHouseId(houseId);
        picPath.setPath(path);
        return picClient.insert(path, houseId);
    }

    @Override
    public Bizdto<List<PicPath>> allPath(Integer houseId) {
        return picClient.allPath(houseId);
    }
}
