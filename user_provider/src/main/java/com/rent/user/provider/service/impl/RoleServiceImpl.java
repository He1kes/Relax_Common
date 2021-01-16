package com.rent.user.provider.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heikes.rent_common.pojo.Role;
import com.heikes.rent_common.vo.PageResult;
import com.rent.user.provider.service.RoleService;
import com.rent.user.provider.mapper.RoleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2021/1/11
 * @Time:10:10
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public List<Role> selectRoles(Map<String, Object> map) {
        return roleMapper.selectRoles(map);
    }

    @Override
    public PageResult<Role> selectRoleByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Role> roles = roleMapper.selectRoleByPage();
        PageInfo pageInfo = new PageInfo(roles, 5);
        PageResult<Role> pageResult = new PageResult<>(pageInfo.getPageNum(),
                                                        pageInfo.getPageSize(),
                                                        pageInfo.getPages(),
                                                        pageInfo.getNavigatepageNums(),
                                                        pageInfo.getTotal(),
                                                        pageInfo.getList());
        return pageResult;
    }
}
