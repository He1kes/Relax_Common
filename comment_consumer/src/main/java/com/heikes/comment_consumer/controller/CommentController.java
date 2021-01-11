package com.heikes.comment_consumer.controller;

import com.github.pagehelper.PageInfo;
import com.heikes.comment_consumer.service.CommentService;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.Comment;
import com.heikes.rent_common.vo.ResultVo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/consumer/comment")
public class CommentController {
    @Resource
    private CommentService commentService;

    //查询用户评论admin
    @RequestMapping("/back/allComment")
    public ResultVo<PageInfo<Comment>> allComment(@RequestParam("pageNum") Integer pageNum,
                                         @RequestParam("pageSize") Integer pageSize,
                                         @RequestParam(value = "userName",required = false) String userName,
                                         @RequestParam(value = "houseName",required = false) String houseName){
        Bizdto<PageInfo<Comment>> bizdto = commentService.allComment(pageNum, pageSize, userName, houseName);
        boolean flag = false;
        if (bizdto.getData() != null){
            flag = true;
            return new ResultVo<>(flag, StatusCode.OK, bizdto.getMessage(),bizdto.getData());
        }else {
            return new ResultVo<>(flag, bizdto.getCode(), bizdto.getMessage(),bizdto.getData());
        }
    }

    //删除评论
    @RequestMapping("/back/deleteComment")
    public ResultVo<Integer> deleteComment(@RequestParam("id") Long id){
        Bizdto<Integer> bizdto = commentService.deleteByPrimaryKey(id);
        boolean flag = false;
        if (bizdto.getData() == 1){
            flag = true;
            return new ResultVo<>(flag,StatusCode.OK,bizdto.getMessage(),bizdto.getData());
        }
        return new ResultVo<>(flag,bizdto.getCode(),bizdto.getMessage(),bizdto.getData());
    }

    //查询该用户的评论
    @RequestMapping("/font/private/userComment")
    public ResultVo<PageInfo<Comment>> userComment(@RequestParam("pageNum") Integer pageNum,
                                                   @RequestParam("pageSize") Integer pageSize,
                                                   @RequestParam("id") Long id){
        Bizdto<PageInfo<Comment>> bizdto = commentService.allUserComment(pageNum, pageSize, id);
        boolean flag = false;
        if (bizdto.getData() != null){
            flag = true;
            return new ResultVo<>(flag, StatusCode.OK,bizdto.getMessage(),bizdto.getData());
        }else {
            return new ResultVo<>(flag,bizdto.getCode(),bizdto.getMessage(),bizdto.getData());
        }
    }



    //添加评论
    @RequestMapping("/font/private/addComment")
    public ResultVo<Integer> addComment(@RequestParam("id") Integer id,
                                        @RequestParam("content") String content,
                                        @RequestParam("availabilityId") Integer availabilityId){
        Bizdto<Integer> bizdto = commentService.insert(id, content, availabilityId);
        boolean flag = false;
        if (bizdto.getData() == 1){
            flag = true;
            return new ResultVo<>(flag,StatusCode.OK,bizdto.getMessage(),bizdto.getData());
        }
        return new ResultVo<>(flag,bizdto.getCode(),bizdto.getMessage(),bizdto.getData());
    }
}
