package com.rent.order_provider.mapper;

import com.heikes.rent_common.pojo.AvailabilityStatus;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AvailabilityStatusMapper {
    //删除
    int deleteByPrimaryKey(Long id);

    //添加
    int insert(AvailabilityStatus record);

    int insertSelective(AvailabilityStatus record);

    AvailabilityStatus selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AvailabilityStatus record);

    int updateByPrimaryKey(AvailabilityStatus record);
    //检查预定
    int checkHouseStatus(String start,String stop,Integer houseId);
}
