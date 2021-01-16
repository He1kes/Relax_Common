package com.rent.chat_consumer.controller;

import com.github.pagehelper.PageInfo;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.ChatMessage;
import com.heikes.rent_common.vo.ResultVo;
import com.rent.chat_consumer.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /*通过token拿userId*/
    @RequestMapping("/front/private/getUserIdByToken")
    public ResultVo<String> getUserIdByToken(HttpServletRequest request){
        String token = request.getHeader("token");
        ResultVo<String> resultVo = new ResultVo<>();
        String tokenTemp = token == null ? "" : token;
        String userId = (String) stringRedisTemplate.opsForHash().get(tokenTemp, "userId");
        if(userId != null){
            resultVo.setFlag(true);
            resultVo.setData(userId);
        }else {
            resultVo.setFlag(false);
            resultVo.setMessage("获取userId出错！chat-con-c");
        }
        return resultVo;
    }

    /*获取与自己有聊天记录的所有用户的id
    * receiver_id=selfId（好像不对）*/
    @RequestMapping("/front/private/getOthersList")
    public ResultVo<PageInfo<String>> getOthersList(
            @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize,
            @RequestParam("selfId") Long selfId){
        Bizdto<PageInfo<String>> bizdto = chatService.getOthersList(pageNo, pageSize, selfId);
        ResultVo<PageInfo<String>> resultVo = new ResultVo<>();
        if(bizdto.getCode() == StatusCode.OK){
            resultVo.setFlag(true);
            resultVo.setData(bizdto.getData());
        }else {
            resultVo.setFlag(false);
            resultVo.setMessage("getOthersList获取数据出现错误！chat-con-c");
        }
        return resultVo;
    }

    /*根据对方id、自己id获取聊天详细信息*/
    @RequestMapping("/front/private/getChatDetail")
    public ResultVo<List<ChatMessage>> getChatDetail(
            @RequestParam("otherId") Long otherId,@RequestParam("selfId") Long selfId){
        Bizdto<List<ChatMessage>> bizdto = chatService.getChatDetail(otherId, selfId);
        ResultVo<List<ChatMessage>> resultVo = new ResultVo<>();
        if(bizdto.getCode() == StatusCode.OK){
            resultVo.setFlag(true);
            resultVo.setData(bizdto.getData());
        }else {
            resultVo.setFlag(false);
            resultVo.setMessage("getChatDetail获取数据出现错误！chat-con-c");
        }
        return resultVo;
    }

    /*未读消息条数
    * 对自己而言，即接收方是自己：receiver_id=selfId（好像不对）*/
    @RequestMapping("/front/private/noViewCounts")
    public ResultVo<Integer> noViewCounts(@RequestParam("otherId") Long otherId,@RequestParam("selfId") Long selfId){
        Bizdto<Integer> bizdto = chatService.noViewCounts(otherId, selfId);
        ResultVo<Integer> resultVo = new ResultVo<>();
        if(bizdto.getCode() == StatusCode.OK){
            resultVo.setFlag(true);
            resultVo.setData(bizdto.getData());
        }else {
            resultVo.setFlag(false);
            resultVo.setMessage("noViewCounts获取数据出现错误！chat-con-c");
        }
        return resultVo;
    }

    /*未读消息id数组*/
    @RequestMapping("/front/private/noViewIds")
    public ResultVo<List<Long>> noViewIds(@RequestParam("otherId") Long otherId,@RequestParam("selfId") Long selfId){
        Bizdto<List<Long>> bizdto = chatService.noViewIds(otherId, selfId);
        ResultVo<List<Long>> resultVo = new ResultVo<>();
        if(bizdto.getCode() == StatusCode.OK){
            resultVo.setFlag(true);
            resultVo.setData(bizdto.getData());
        }else {
            resultVo.setFlag(false);
            resultVo.setMessage("noViewIds获取数据出现错误！chat-con-c");
        }
        return resultVo;
    }

    /*将未读消息置为已读*/
    @RequestMapping("/front/private/setViewedIds")
    public ResultVo<Integer> setViewedIds(@RequestParam("otherId") Long otherId,@RequestParam("selfId") Long selfId){
        ResultVo<Integer> resultVo = new ResultVo<>();
        Bizdto<List<Long>> bizdtoIds = chatService.noViewIds(otherId, selfId);
        List<Long> chatIdList = bizdtoIds.getData();
        int count = 0;
        if(chatIdList != null){
            for(Long id : chatIdList){
                chatService.setViewed(id);
                count++;
            }
        }
        if(count > 0){
            resultVo.setFlag(true);
            resultVo.setData(count);
        }else {
            resultVo.setFlag(false);
            resultVo.setMessage("暂无未读消息！chat-con-c");
        }
        return resultVo;
    }

    /*将消息存储到数据库*/
    @RequestMapping("/front/private/storeChat")
    public ResultVo<Integer> storeChat(@RequestBody ChatMessage chatMessage){
        chatMessage.setSendDate(new Date());
        chatMessage.setViewStatus(0);
        Bizdto<Integer> bizdto = chatService.storeChat(chatMessage);
        ResultVo<Integer> resultVo = new ResultVo<>();
        if(bizdto.getCode() == StatusCode.OK){
            resultVo.setFlag(true);
            resultVo.setData(bizdto.getData());
        }else {
            resultVo.setFlag(false);
            resultVo.setMessage("storeChat获取数据出现错误！chat-con-c");
        }
        return resultVo;
    }

    /*后台，根据自己的id，获取与自己有聊天记录的所有用户的id*/
    @RequestMapping("/front/private/getOthersListBack")
    public ResultVo<PageInfo<String>> getOthersListBack(
            @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize,
            @RequestParam("selfId") Long selfId){
        Bizdto<PageInfo<String>> bizdto = chatService.getOthersListBack(pageNo, pageSize, selfId);
        ResultVo<PageInfo<String>> resultVo = new ResultVo<>();
        if(bizdto.getCode() == StatusCode.OK){
            resultVo.setFlag(true);
            resultVo.setData(bizdto.getData());
        }else {
            resultVo.setFlag(false);
            resultVo.setMessage("getOthersListBack获取数据出现错误！chat-con-c");
        }
        return resultVo;
    }
}
