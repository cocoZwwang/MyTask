package com.rwby.mytask.db.domain;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

import java.util.Date;

@Entity
public class Task {
    @Id(autoincrement = true)
    private Long id;

    @Unique
    private String title;

    private String content;

    // 0：待完成 1：已完成 2：已逾期
    private int status;

    //0: 日常  1：周常
    private int type;

    private Date completedDate;

    private Date createTime;

    private Date updateTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Generated(hash = 356126865)
    public Task(Long id, String title, String content, int status, int type,
            Date completedDate, Date createTime, Date updateTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.type = type;
        this.completedDate = completedDate;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    @Generated(hash = 733837707)
    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", type=" + type +
                ", completedDate=" + completedDate +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
