package com.heikes.comment_provider.service;

import com.github.pagehelper.PageInfo;
import com.heikes.rent_common.pojo.Comment;


public interface CommentService {
    //删除
    int deleteByPrimaryKey(Long id);

    //查询全部评论
    PageInfo<Comment> allComment(Integer pageNum,Integer pageSize,String houseName, String userName);

    //根据用户id查询评论
    PageInfo<Comment> allUserComment(Integer pageNum,Integer pageSize,Long id);

    //添加
    int insert(Integer userId,String content,Integer availabilityId);
}
