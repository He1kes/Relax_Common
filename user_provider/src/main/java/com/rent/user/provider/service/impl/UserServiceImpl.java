package com.rent.user.provider.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heikes.rent_common.pojo.User;
import com.heikes.rent_common.pojo.UserRole;
import com.heikes.rent_common.utils.IdWorker;
import com.heikes.rent_common.vo.PageResult;
import com.heikes.rent_common.pojo.Users;
import com.rent.user.provider.mapper.UserMapper;
import com.rent.user.provider.mapper.UserRoleMapper;
import com.rent.user.provider.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Create By Intellij IDEA
 *
 * @Author :HP
 * @Date:2020/12/29
 * @Time:15:42
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Resource
    private IdWorker idWorker;

    /**
     * @param user
     * @return
     * 添加普通用户
     */
    @Override
    public boolean insertNormalUser(User user, Long roleId) {
        user.setId(idWorker.nextId());
        user.setUserStatus(0);
        int userFlag = userMapper.insert(user);
        UserRole userRole = new UserRole();
        userRole.setId(idWorker.nextId());
        //4代表普通用户的角色
        userRole.setRoleId(roleId);
        userRole.setUserId(user.getId());
        int userRoleFlag = userRoleMapper.insert(userRole);

        return userFlag == 1 && userRoleFlag == 1;
    }

    /**
     * @param userAccount
     * @return
     * 查询头像地址
     */
    @Override
    public User selectUserImg(String userAccount) {
        return userMapper.selectUserImg(userAccount);
    }

    @Override
    public User selectByLogin(String userAccount, String password) {
        return userMapper.selectByLogin(userAccount, password);
    }

    @Override
    public User selectUserByColumn(Map<String, Object> columns) {
        return userMapper.selectUserByColumn(columns);
    }

    @Override
    public Boolean updateColumnById(Map<String, Object> map) {
        return userMapper.updateColumnById(map);
    }

    @Override
    public PageResult<Users> selectUserListByColumn(Map<String, Object> map) {
        int pageNow = Integer.parseInt(map.get("pageNum").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        PageHelper.startPage(pageNow, pageSize);
        List<Users> list = userMapper.selectUserListByColumn(map);
        PageInfo<Users> pageInfo = new PageInfo<>(list, 5);
        PageResult<Users> pageResult = new PageResult<Users>(pageInfo.getPageNum(),
                                                            pageInfo.getPageSize(),
                                                            pageInfo.getPages(),
                                                            pageInfo.getNavigatepageNums(),
                                                            pageInfo.getTotal(),
                                                            pageInfo.getList());
        return pageResult;
    }
}
