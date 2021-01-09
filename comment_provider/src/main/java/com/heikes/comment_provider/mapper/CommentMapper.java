package com.heikes.comment_provider.mapper;

import com.heikes.rent_common.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

public interface CommentMapper {
    //删除
    int deleteByPrimaryKey(Long id);

    int insert(Integer userId, String content, Integer availabilityId, Date date);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    //查询全部评论
    List<Comment> allComment(String houseName,String userName);

    //根据用户id查询评论
    List<Comment> allUserComment(Long id);
}