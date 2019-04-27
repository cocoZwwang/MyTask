package com.rwby.mytask.enum_type;

public enum TaskType {
    TASK_TYPE_WEEK(1, "周常"),
    TASK_TYPE_DAY(0, "日常");
    public final int code;

    public final String name;

    TaskType(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
