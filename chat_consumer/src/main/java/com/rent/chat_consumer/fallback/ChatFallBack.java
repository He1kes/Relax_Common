package com.rent.chat_consumer.fallback;

import com.github.pagehelper.PageInfo;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.ChatMessage;
import com.rent.chat_consumer.client.ChatClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChatFallBack implements FallbackFactory<ChatClient> {
    @Override
    public ChatClient create(Throwable throwable) {
        return new ChatClient() {
            @Override
            public Bizdto<PageInfo<String>> getOthersList(Integer pageNo, Integer pageSize, Long selfId) {
                Bizdto<PageInfo<String>> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage("熔断，获取聊天用户列表时发生错误。");
                return bizdto;
            }

            @Override
            public Bizdto<List<ChatMessage>> getChatDetail(Long otherId, Long selfId) {
                Bizdto<List<ChatMessage>> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage("熔断，获取聊天详细信息时发生错误。");
                return bizdto;
            }

            @Override
            public Bizdto<Integer> storeChat(ChatMessage chatMessage) {
                Bizdto<Integer> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage("熔断，存储聊天信息时发生错误。");
                return bizdto;
            }

            @Override
            public Bizdto<Integer> noViewCounts(Long otherId, Long selfId) {
                Bizdto<Integer> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage("熔断，noViewCounts方法发生错误。");
                return bizdto;
            }

            @Override
            public Bizdto<List<Long>> noViewIds(Long otherId, Long selfId) {
                Bizdto<List<Long>> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage("熔断，noViewIds方法发生错误。");
                return bizdto;
            }

            @Override
            public Bizdto<Integer> setViewed(Long chatId) {
                Bizdto<Integer> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage("熔断，setViewed方法发生错误。");
                return bizdto;
            }

            @Override
            public Bizdto<PageInfo<String>> getOthersListBack(Integer pageNo, Integer pageSize, Long selfId) {
                Bizdto<PageInfo<String>> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage("熔断，后台获取聊天用户列表时发生错误。");
                return bizdto;
            }
        };
    }
}
