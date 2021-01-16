package com.rent.chat_provider.service.impl;

import com.heikes.rent_common.pojo.ChatMessage;
import com.rent.chat_provider.mapper.ChatMapper;
import com.rent.chat_provider.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    private ChatMapper chatMapper;

    @Override
    public List<String> getOthersList(Long selfId) {
        return chatMapper.getOthersList(selfId);
    }


    @Override
    public int noViewCounts(Long otherId, Long selfId) {
        return chatMapper.noViewCounts(otherId, selfId);
    }

    @Override
    public List<Long> noViewIds(Long otherId, Long selfId) {
        return chatMapper.noViewIds(otherId, selfId);
    }

    @Override
    public int setViewed(Long chatId) {
        return chatMapper.setViewed(chatId);
    }

    @Override
    public List<ChatMessage> getChatDetail(Long otherId, Long selfId) {
        return chatMapper.getChatDetail(otherId, selfId);
    }

    @Override
    public int storeChat(ChatMessage chatMessage) {
        return chatMapper.storeChat(chatMessage);
    }

    @Override
    public List<String> getOthersListBack(Long selfId) {
        return chatMapper.getOthersListBack(selfId);
    }
}
