package com.heikes.house_consumer.service.impl;

import com.heikes.house_consumer.service.OffService;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.Off;
import com.heikes.rent_common.remote.house.OffRemote;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class OffServiceImpl implements OffService {
    @Resource
    private OffRemote offRemote;
    @Override
    public Bizdto<List<Off>> offAll() {
        return offRemote.allOff();
    }
}
