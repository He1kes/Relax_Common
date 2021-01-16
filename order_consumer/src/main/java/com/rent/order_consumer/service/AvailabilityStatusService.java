package com.rent.order_consumer.service;

import com.heikes.rent_common.dto.Bizdto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface AvailabilityStatusService {
    //添
    Bizdto<Integer> addStatus(String startDate, String stopDate, Integer houseId);
    //删除
    Bizdto<Integer> deleteStatus(Integer id);
    //查询
    Bizdto<Integer> checkStatus(String startDate, String stopDate, Integer houseId);
}
