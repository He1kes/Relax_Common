package com.rent.chat_consumer.service.impl;

import com.github.pagehelper.PageInfo;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.pojo.ChatMessage;
import com.rent.chat_consumer.client.ChatClient;
import com.rent.chat_consumer.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    private ChatClient chatClient;

    @Override
    public Bizdto<PageInfo<String>> getOthersList(Integer pageNo, Integer pageSize, Long selfId) {
        Bizdto<PageInfo<String>> bizdto = chatClient.getOthersList(pageNo, pageSize, selfId);
        return bizdto;
    }

    @Override
    public Bizdto<Integer> noViewCounts(Long otherId, Long selfId) {
        Bizdto<Integer> bizdto = chatClient.noViewCounts(otherId, selfId);
        return bizdto;
    }

    @Override
    public Bizdto<List<Long>> noViewIds(Long otherId, Long selfId) {
        Bizdto<List<Long>> bizdto = chatClient.noViewIds(otherId, selfId);
        return bizdto;
    }

    @Override
    public Bizdto<Integer> setViewed(Long chatId) {
        Bizdto<Integer> bizdto = chatClient.setViewed(chatId);
        return bizdto;
    }

    @Override
    public Bizdto<List<ChatMessage>> getChatDetail(Long otherId, Long selfId) {
        Bizdto<List<ChatMessage>> bizdto = chatClient.getChatDetail(otherId,selfId);
        return bizdto;
    }

    @Override
    public Bizdto<Integer> storeChat(ChatMessage chatMessage) {
        Bizdto<Integer> bizdto = chatClient.storeChat(chatMessage);
        return bizdto;
    }

    @Override
    public Bizdto<PageInfo<String>> getOthersListBack(Integer pageNo, Integer pageSize, Long selfId) {
        Bizdto<PageInfo<String>> bizdto = chatClient.getOthersListBack(pageNo, pageSize, selfId);
        return bizdto;
    }
}
