package com.rent.chat_provider.service;

import com.heikes.rent_common.pojo.ChatMessage;

import java.util.List;

public interface ChatService {
    /*根据自己的id，获取与自己有聊天记录的所有用户的id*/
    public List<String> getOthersList(Long selfId);

    /*未读消息条数*/
    public int noViewCounts(Long otherId,Long selfId);

    /*未读消息id数组*/
    public List<Long> noViewIds(Long otherId,Long selfId);

    /*将未读消息置为已读*/
    public int setViewed(Long chatId);

    /*根据对方id、自己id获取聊天详细信息*/
    public List<ChatMessage> getChatDetail(Long otherId, Long selfId);

    /*将消息存储到数据库*/
    public int storeChat(ChatMessage chatMessage);

    /*后台，根据自己的id，获取与自己有聊天记录的所有用户的id*/
    public List<String> getOthersListBack(Long selfId);
}
