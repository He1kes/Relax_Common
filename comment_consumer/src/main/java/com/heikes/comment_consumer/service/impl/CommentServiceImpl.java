package com.heikes.comment_consumer.service.impl;

import com.github.pagehelper.PageInfo;
import com.heikes.comment_consumer.client.CommentClient;
import com.heikes.comment_consumer.service.CommentService;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.Comment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentClient commentClient;

    @Override
    public Bizdto<Integer> deleteByPrimaryKey(Long id) {
        return commentClient.deleteComment(id);
    }

    @Override
    public Bizdto<PageInfo<Comment>> allComment(Integer pageNum, Integer pageSize, String houseName, String userName) {
        return commentClient.allComment(pageNum, pageSize, houseName, userName);
    }

    @Override
    public Bizdto<PageInfo<Comment>> allUserComment(Integer pageNum, Integer pageSize, Long id) {
        return commentClient.userComment(pageNum, pageSize, id);
    }

    @Override
    public Bizdto<Integer> insert(Integer id, String content, Integer availabilityId) {
        return commentClient.addComment(id, content, availabilityId);
    }
}
