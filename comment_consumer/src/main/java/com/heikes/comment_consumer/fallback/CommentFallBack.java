package com.heikes.comment_consumer.fallback;

import com.github.pagehelper.PageInfo;
import com.heikes.comment_consumer.client.CommentClient;
import com.heikes.rent_common.dto.Bizdto;
import com.heikes.rent_common.meiju.StatusCode;
import com.heikes.rent_common.pojo.Comment;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class CommentFallBack implements FallbackFactory<CommentClient> {
    @Override
    public CommentClient create(Throwable throwable) {
        return new CommentClient() {
            @Override
            public Bizdto<PageInfo<Comment>> allComment(Integer pageNum, Integer pageSize, String userName, String houseName) {
                Bizdto<PageInfo<Comment>> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage(throwable.getMessage());
                return bizdto;
            }

            @Override
            public Bizdto<PageInfo<Comment>> userComment(Integer pageNum, Integer pageSize, Long id) {
                Bizdto<PageInfo<Comment>> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage(throwable.getMessage());
                return bizdto;
            }

            @Override
            public Bizdto<Integer> deleteComment(Long id) {
                Bizdto<Integer> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage(throwable.getMessage());
                return bizdto;
            }

            @Override
            public Bizdto<Integer> addComment(Integer id, String content, Integer availabilityId) {
                Bizdto<Integer> bizdto = new Bizdto<>();
                bizdto.setCode(StatusCode.REMOTEERROR);
                bizdto.setMessage(throwable.getMessage());
                return bizdto;
            }
        };
    }
}
