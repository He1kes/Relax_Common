package com.heikes.comment_provider.controller;

import com.github.pagehelper.PageInfo;
import com.heikes.comment_provider.service.CommentService;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.Comment;
import com.heikes.rent_common.remote.comment.CommentRemote;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin(origins = "*")
public class CommentController implements CommentRemote {
    @Resource
    private CommentService commentService;

    @Override
    public Bizdto<PageInfo<Comment>> allComment(Integer pageNum, Integer pageSize, String userName, String houseName) {
        Bizdto<PageInfo<Comment>> bizdto = new Bizdto<>();
        bizdto.setCode(StatusCode.OK);
        bizdto.setMessage("查询成功");
        bizdto.setData(commentService.allComment(pageNum, pageSize, userName, houseName));
        return bizdto;
    }

    @Override
    public Bizdto<PageInfo<Comment>> userComment(Integer pageNum, Integer pageSize, Long id) {
        Bizdto<PageInfo<Comment>> bizdto = new Bizdto<>();
        bizdto.setCode(StatusCode.OK);
        bizdto.setMessage("查询成功");
        bizdto.setData(commentService.allUserComment(pageNum, pageSize, id));
        return bizdto;
    }

    @Override
    public Bizdto<Integer> deleteComment(Long id) {
        Bizdto<Integer> bizdto = new Bizdto<>();
        int count = commentService.deleteByPrimaryKey(id);
        if (count == 1){
            bizdto.setCode(StatusCode.OK);
            bizdto.setMessage("删除成功");
            bizdto.setData(count);
        }else {
            bizdto.setCode(StatusCode.ERROR);
            bizdto.setMessage("删除失败");
            bizdto.setData(count);
        }
        return bizdto;
    }

    @Override
    public Bizdto<Integer> addComment(Integer userId, String content, Integer availabilityId) {
        Bizdto<Integer> bizdto = new Bizdto<>();
        int count = commentService.insert(userId, content, availabilityId);
        if (count == 1){
            bizdto.setCode(StatusCode.OK);
            bizdto.setMessage("评论成功");
            bizdto.setData(count);
        }else {
            bizdto.setCode(StatusCode.ERROR);
            bizdto.setMessage("评论失败");
            bizdto.setData(count);
        }
        return bizdto;
    }

}
