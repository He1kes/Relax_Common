package com.heikes.rent_common.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author yanxin
 * @since 2020-12-24
 */
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 关联房源表的房源id
     */
    private Integer availabilityId;

    /**
     * 评论的具体内容	
     */
    private String content;

    /**
     * 关联用户表的id
     */
    private Integer userId;

    /**
     * 评论日期	
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(
            pattern = "yyyy-MM-dd",
            timezone = "GMT+8"
    )
    private Date date;

    private String userName;

    private String houseName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getAvailabilityId() {
        return availabilityId;
    }

    public void setAvailabilityId(Integer availabilityId) {
        this.availabilityId = availabilityId;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", availabilityId=" + availabilityId +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", date=" + date +
                ", userName='" + userName + '\'' +
                ", houseName='" + houseName + '\'' +
                '}';
    }
}
