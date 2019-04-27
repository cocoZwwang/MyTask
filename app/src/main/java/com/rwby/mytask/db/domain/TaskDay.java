package com.rwby.mytask.db.domain;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class TaskDay {
    @Id(autoincrement = true)
    private Long id;

    @Unique
    private String title;

    private String content;

    // 0：未激活 1：激活
    private int status;

    @Generated(hash = 1200471735)
    public TaskDay(Long id, String title, String content, int status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
    }

    @Generated(hash = 1973552788)
    public TaskDay() {
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
}
