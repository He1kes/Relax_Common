package com.rent.coupon.provider.mapper;


import com.heikes.rent_common.pojo.CouponUser;

import java.util.List;

public interface CouponUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CouponUser record);

    CouponUser selectByPrimaryKey(Long id);

    List<CouponUser> selectAll();

    int updateByPrimaryKey(CouponUser record);
}