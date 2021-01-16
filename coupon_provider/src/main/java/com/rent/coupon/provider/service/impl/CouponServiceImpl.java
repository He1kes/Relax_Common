package com.rent.coupon.provider.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.Coupon;
import com.heikes.rent_common.vo.PageResult;
import com.rent.coupon.provider.mapper.CouponMapper;
import com.rent.coupon.provider.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/16
 * @Time:9:40
 */
@Transactional
@Service
public class CouponServiceImpl implements CouponService {

    @Resource
    private CouponMapper couponMapper;

    @Override
    public boolean insertCoupon(Coupon coupon) {
        return couponMapper.insertCoupon(coupon) == 1;
    }

    @Override
    public Bizdto<PageResult<Coupon>> getCouponList(Map<String, Object> map) {
        int pageNum = Integer.parseInt(map.get("pageNum").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        PageHelper.startPage(pageNum, pageSize);
        List<Coupon> list = couponMapper.selectCouponList(map);
        PageInfo<Coupon> pageInfo = new PageInfo<>(list, 5);
        PageResult<Coupon> pageResult = new PageResult<>(
                pageInfo.getPageNum(),
                pageInfo.getPageSize(),
                pageInfo.getPages(),
                pageInfo.getNavigatepageNums(),
                pageInfo.getTotal(),
                pageInfo.getList()
        );
        Bizdto<PageResult<Coupon>> bizdto = new Bizdto<>();
        bizdto.setData(pageResult);
        bizdto.setMessage("查询成功");
        bizdto.setCode(StatusCode.OK);
        return bizdto;
    }
}
