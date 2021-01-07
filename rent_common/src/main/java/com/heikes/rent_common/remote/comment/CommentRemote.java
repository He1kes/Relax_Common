package com.heikes.rent_common.remote.comment;

import com.github.pagehelper.PageInfo;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.Comment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


public interface CommentRemote {
    //查询用户评论admin
    @RequestMapping("/comment/allComment")
    Bizdto<PageInfo<Comment>> allComment(@RequestParam("pageNum") Integer pageNum,
                                         @RequestParam("pageSize") Integer pageSize,
                                         @RequestParam(value = "userName",required = false) String userName,
                                         @RequestParam(value = "houseName",required = false) String houseName);

    //查询该用户的评论
    @RequestMapping("/comment/userComment")
    Bizdto<PageInfo<Comment>> userComment(@RequestParam("pageNum") Integer pageNum,
                                      @RequestParam("pageSize") Integer pageSize,
                                      @RequestParam("id") Long id);

    //删除评论
    @RequestMapping("/comment/deleteComment")
    Bizdto<Integer> deleteComment(@RequestParam("id") Long id);

    //添加用户评论
    @RequestMapping("/comment/addComment")
    Bizdto<Integer> addComment(@RequestParam("userId") Integer userId,
                               @RequestParam("content") String content,
                               @RequestParam("availabilityId") Integer availabilityId);
}
