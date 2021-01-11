package com.heikes.comment_consumer.service;

import com.github.pagehelper.PageInfo;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.Comment;

public interface CommentService {
    //删除
    Bizdto<Integer> deleteByPrimaryKey(Long id);

    //查询全部评论
    Bizdto<PageInfo<Comment>> allComment(Integer pageNum, Integer pageSize, String houseName, String userName);

    //根据用户id查询评论
    Bizdto<PageInfo<Comment>> allUserComment(Integer pageNum,Integer pageSize,Long id);

    //添加评论
    Bizdto<Integer> insert(Integer id,String content,Integer availabilityId);
}
