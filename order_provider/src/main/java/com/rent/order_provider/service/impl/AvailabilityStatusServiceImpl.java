package com.rent.order_provider.service.impl;

import com.heikes.rent_common.pojo.AvailabilityStatus;
import com.rent.order_provider.mapper.AvailabilityStatusMapper;
import com.rent.order_provider.service.AvailabilityStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AvailabilityStatusServiceImpl implements AvailabilityStatusService {
    @Autowired
    private AvailabilityStatusMapper availabilityStatusMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return availabilityStatusMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(String startDate, String stopDate, Integer houseId) {
        AvailabilityStatus availabilityStatus = new AvailabilityStatus();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date sdate = simpleDateFormat.parse(startDate);
            Date edate = simpleDateFormat.parse(stopDate);
            availabilityStatus.setStartDate(sdate);
            availabilityStatus.setStopDate(edate);
            availabilityStatus.setHouseId(houseId);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return availabilityStatusMapper.insert(availabilityStatus);
    }

    @Override
    public int insertSelective(AvailabilityStatus record) {
        return availabilityStatusMapper.insertSelective(record);
    }

    @Override
    public AvailabilityStatus selectByPrimaryKey(Long id) {
        return availabilityStatusMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AvailabilityStatus record) {
        return availabilityStatusMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AvailabilityStatus record) {
        return availabilityStatusMapper.updateByPrimaryKey(record);
    }

    @Override
    public int checkHouseStatus(String start, String stop, Integer houseId) {
        return availabilityStatusMapper.checkHouseStatus(start, stop, houseId);
    }
}
