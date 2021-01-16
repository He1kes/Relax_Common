package com.rent.chat_provider.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.ChatMessage;
import com.heikes.rent_common.remote.chat.ChatRemote;
import com.rent.chat_provider.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatController implements ChatRemote {
    @Autowired
    private ChatService chatService;

    /*根据自己的id，获取与自己有聊天记录的所有用户的id*/
    @Override
    public Bizdto<PageInfo<String>> getOthersList(Integer pageNo, Integer pageSize, Long selfId) {
        PageHelper.startPage(pageNo,pageSize);
        List<String> othersIds = chatService.getOthersList(selfId);
        PageInfo<String> pageInfo = new PageInfo<>(othersIds,5);
        Bizdto<PageInfo<String>> bizdto = new Bizdto<>();
        bizdto.setCode(StatusCode.OK);
        bizdto.setMessage("getOthersList方法执行成功chat-pro-c。");
        bizdto.setData(pageInfo);
        return bizdto;
    }

    /*未读消息条数*/
    @Override
    public Bizdto<Integer> noViewCounts(Long otherId, Long selfId) {
        int count = chatService.noViewCounts(otherId, selfId);
        Bizdto<Integer> bizdto = new Bizdto<>();
        bizdto.setCode(StatusCode.OK);
        bizdto.setMessage("noViewCounts方法执行成功chat-pro-c。");
        bizdto.setData(count);
        return bizdto;
    }

    /*未读消息id数组*/
    @Override
    public Bizdto<List<Long>> noViewIds(Long otherId, Long selfId) {
        List<Long> noViewIdList = chatService.noViewIds(otherId, selfId);
        Bizdto<List<Long>> bizdto = new Bizdto<>();
        bizdto.setCode(StatusCode.OK);
        bizdto.setMessage("noViewIds方法执行成功chat-pro-c。");
        bizdto.setData(noViewIdList);
        return bizdto;
    }

    /*将未读消息置为已读*/
    @Override
    public Bizdto<Integer> setViewed(Long chatId) {
        int count = chatService.setViewed(chatId);
        Bizdto<Integer> bizdto = new Bizdto<>();
        if(count > 0){
            bizdto.setCode(StatusCode.OK);
            bizdto.setMessage("setViewed方法执行成功chat-pro-c。");
            bizdto.setData(count);
        }else {
            bizdto.setCode(StatusCode.ERROR);
            bizdto.setMessage("setViewed方法执行失败chat-pro-c。");
            bizdto.setData(count);
        }
        return bizdto;
    }

    /*根据对方id、自己id获取聊天详细信息*/
    @Override
    public Bizdto<List<ChatMessage>> getChatDetail(Long otherId, Long selfId) {
        List<ChatMessage> chatMessageList = chatService.getChatDetail(otherId, selfId);
        Bizdto<List<ChatMessage>> bizdto = new Bizdto<>();
        bizdto.setCode(StatusCode.OK);
        bizdto.setMessage("getChatDetail方法执行成功chat-pro-c。");
        bizdto.setData(chatMessageList);
        return bizdto;
    }

    /*将消息存储到数据库*/
    @Override
    public Bizdto<Integer> storeChat(ChatMessage chatMessage) {
        int count = chatService.storeChat(chatMessage);
        Bizdto<Integer> bizdto = new Bizdto<>();
        if(count > 0){
            bizdto.setCode(StatusCode.OK);
            bizdto.setMessage("storeChat方法执行成功chat-pro-c。");
            bizdto.setData(count);
        }else {
            bizdto.setCode(StatusCode.ERROR);
            bizdto.setMessage("storeChat方法执行失败chat-pro-c。");
            bizdto.setData(count);
        }
        return bizdto;
    }

    /*后台，根据自己的id，获取与自己有聊天记录的所有用户的id*/
    @Override
    public Bizdto<PageInfo<String>> getOthersListBack(Integer pageNo, Integer pageSize, Long selfId) {
        PageHelper.startPage(pageNo,pageSize);
        List<String> othersIds = chatService.getOthersListBack(selfId);
        PageInfo<String> pageInfo = new PageInfo<>(othersIds,5);
        Bizdto<PageInfo<String>> bizdto = new Bizdto<>();
        bizdto.setCode(StatusCode.OK);
        bizdto.setMessage("getOthersListBack方法执行成功chat-pro-c。");
        bizdto.setData(pageInfo);
        return bizdto;
    }
}
