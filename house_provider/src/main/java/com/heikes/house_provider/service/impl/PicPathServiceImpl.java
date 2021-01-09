package com.heikes.house_provider.service.impl;

import com.heikes.house_provider.mapper.PicPathMapper;
import com.heikes.house_provider.service.PicPathService;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.PicPath;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class PicPathServiceImpl implements PicPathService {
    @Resource
    private PicPathMapper picPathMapper;

    @Override
    public int insert(String path,Integer houseId) {
        PicPath picPath = new PicPath();
        picPath.setPath(path);
        picPath.setHouseId(houseId);
        return picPathMapper.insert(picPath);
    }

    @Override
    public List<PicPath> allPath(Integer houseId) {
        return picPathMapper.allPath(houseId);
    }
}
