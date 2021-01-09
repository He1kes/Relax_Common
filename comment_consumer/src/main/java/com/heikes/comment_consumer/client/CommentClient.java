package com.heikes.comment_consumer.client;

import com.heikes.comment_consumer.fallback.CommentFallBack;
import com.heikes.rent_common.remote.comment.CommentRemote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@FeignClient(name = "comment-provider", fallbackFactory = CommentFallBack.class)
public interface CommentClient extends CommentRemote  {
}
