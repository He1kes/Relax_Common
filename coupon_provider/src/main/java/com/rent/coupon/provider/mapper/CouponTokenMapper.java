package com.rent.coupon.provider.mapper;


import com.heikes.rent_common.pojo.CouponToken;

import java.util.List;

public interface CouponTokenMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CouponToken record);

    CouponToken selectByPrimaryKey(Long id);

    List<CouponToken> selectAll();

    int updateByPrimaryKey(CouponToken record);
}