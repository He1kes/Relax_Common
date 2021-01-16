package com.rent.chat_consumer.service;

import com.github.pagehelper.PageInfo;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.ChatMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ChatService {

    /*根据自己的id，获取与自己有聊天记录的所有用户的id*/
    public Bizdto<PageInfo<String>> getOthersList(Integer pageNo, Integer pageSize, Long selfId);

    /*未读消息条数*/
    public Bizdto<Integer> noViewCounts(Long otherId,Long selfId);

    /*未读消息id数组*/
    public Bizdto<List<Long>> noViewIds(Long otherId,Long selfId);

    /*将未读消息置为已读*/
    public Bizdto<Integer> setViewed(Long chatId);

    /*根据对方id、自己id获取聊天详细信息*/
    public Bizdto<List<ChatMessage>> getChatDetail(Long otherId,Long selfId);

    /*将消息存储到数据库*/
    public Bizdto<Integer> storeChat(ChatMessage chatMessage);

    /*后台，根据自己的id，获取与自己有聊天记录的所有用户的id*/
    public Bizdto<PageInfo<String>> getOthersListBack(Integer pageNo, Integer pageSize, Long selfId);
}
