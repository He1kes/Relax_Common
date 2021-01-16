package com.rent.order_consumer.service.impl;

import com.heikes.rent_common.dto.Bizdto;
import com.rent.order_consumer.client.AvailabilityStatusClient;
import com.rent.order_consumer.service.AvailabilityStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvailabilityStatusServiceImpl implements AvailabilityStatusService {
    @Autowired
    private AvailabilityStatusClient availabilityStatusClient;

    @Override
    public Bizdto<Integer> addStatus(String startDate, String stopDate, Integer houseId) {
        return availabilityStatusClient.addStatus(startDate, stopDate, houseId);
    }

    @Override
    public Bizdto<Integer> deleteStatus(Integer id) {
        return availabilityStatusClient.deleteStatus(id);
    }

    @Override
    public Bizdto<Integer> checkStatus(String startDate, String stopDate, Integer houseId) {
        return availabilityStatusClient.checkStatus(startDate, stopDate, houseId);
    }
}
