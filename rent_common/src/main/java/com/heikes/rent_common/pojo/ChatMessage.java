package com.heikes.rent_common.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 聊天信息表
 * </p>
 *
 * @author yanxin
 * @since 2020-12-24
 */
public class ChatMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 发送方id
     */
    private Long senderId;

    /**
     * 发送方姓名
     */
    private String sendName;

    /**
     * 接收方id
     */
    private Long receiverId;

    /**
     * 接收方姓名
     */
    private String receiverName;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 发送时间
     */
    private Date sendDate;

    /**
     * 查看状态（0未查看/1已查看）
     */
    private Integer viewStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }
    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }
    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }
    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }
    public Integer getViewStatus() {
        return viewStatus;
    }

    public void setViewStatus(Integer viewStatus) {
        this.viewStatus = viewStatus;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
            "id=" + id +
            ", senderId=" + senderId +
            ", sendName=" + sendName +
            ", receiverId=" + receiverId +
            ", receiverName=" + receiverName +
            ", content=" + content +
            ", sendDate=" + sendDate +
            ", viewStatus=" + viewStatus +
        "}";
    }
}
