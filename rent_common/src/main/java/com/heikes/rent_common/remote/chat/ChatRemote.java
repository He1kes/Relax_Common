package com.heikes.rent_common.remote.chat;

import com.github.pagehelper.PageInfo;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.ChatMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ChatRemote {

    /*根据自己的id，获取与自己有聊天记录的所有用户的id*/
    @RequestMapping("/getOthersList")
    public Bizdto<PageInfo<Long>> getOthersList(
            @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize,
            @RequestParam("selfId") Long selfId);

    /*未读消息条数*/
    @RequestMapping("/noViewCounts")
    public Bizdto<Integer> noViewCounts(@RequestParam("otherId") Long otherId,@RequestParam("selfId") Long selfId);

    /*未读消息id数组*/
    @RequestMapping("/noViewIds")
    public Bizdto<List<Long>> noViewIds(@RequestParam("otherId") Long otherId,@RequestParam("selfId") Long selfId);

    /*将未读消息置为已读*/
    @RequestMapping("/setViewed")
    public Bizdto<Integer> setViewed(@RequestParam("chatId") Long chatId);

    /*根据对方id、自己id获取聊天详细信息*/
    @RequestMapping("/getChatDetail")
    public Bizdto<List<ChatMessage>> getChatDetail(
            @RequestParam("otherId") Long otherId,@RequestParam("selfId") Long selfId);

    /*将消息存储到数据库*/
    @RequestMapping("/storeChat")
    public Bizdto<Integer> storeChat(@RequestBody ChatMessage chatMessage);

}
