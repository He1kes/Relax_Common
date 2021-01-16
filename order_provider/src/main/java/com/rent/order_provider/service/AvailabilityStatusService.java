package com.rent.order_provider.service;

import com.heikes.rent_common.pojo.AvailabilityStatus;
import org.springframework.web.bind.annotation.RequestParam;

public interface AvailabilityStatusService {
    //删除
    int deleteByPrimaryKey(Long id);

    //添加
    int insert(String startDate, String stopDate, Integer houseId);

    int insertSelective(AvailabilityStatus record);

    AvailabilityStatus selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AvailabilityStatus record);

    int updateByPrimaryKey(AvailabilityStatus record);
    //检查预定
    int checkHouseStatus(String start,String stop,Integer houseId);
}
