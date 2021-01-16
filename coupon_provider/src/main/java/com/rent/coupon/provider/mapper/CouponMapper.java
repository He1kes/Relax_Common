package com.rent.coupon.provider.mapper;


import com.heikes.rent_common.pojo.Coupon;

import java.util.List;
import java.util.Map;

public interface CouponMapper {
    int deleteByPrimaryKey(Long couponId);

    int insert(Coupon record);

    Coupon selectByPrimaryKey(Long couponId);

    List<Coupon> selectAll();

    int updateByPrimaryKey(Coupon record);

    int insertCoupon(Coupon coupon);

    List<Coupon> selectCouponList(Map<String, Object> map);
}