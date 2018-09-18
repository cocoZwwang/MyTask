package com.rwby.mytask.bean;

public class Task {
    public final String title;

    public final String content;

    public final boolean completed;

    public Task(String title, String content, boolean completed) {
        this.title = title;
        this.content = content;
        this.completed = completed;
    }
}
