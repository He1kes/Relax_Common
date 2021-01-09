package com.heikes.comment_provider.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heikes.comment_provider.mapper.CommentMapper;
import com.heikes.comment_provider.service.CommentService;
import com.heikes.rent_common.pojo.Comment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo<Comment> allComment(Integer pageNum, Integer pageSize, String userName, String houseName) {
        PageHelper.startPage(pageNum,pageSize);
        List<Comment> list = commentMapper.allComment(houseName, userName);
        return new PageInfo<Comment>(list,5);
    }

    @Override
    public PageInfo<Comment> allUserComment(Integer pageNum, Integer pageSize, Long id) {
        PageHelper.startPage(pageNum,pageSize);
        List<Comment> list = commentMapper.allUserComment(id);
        return new PageInfo<Comment>(list,5);
    }

    @Override
    public int insert(Integer userId, String content, Integer availabilityId) {
        return commentMapper.insert(userId,content,availabilityId,new Date());
    }
}
