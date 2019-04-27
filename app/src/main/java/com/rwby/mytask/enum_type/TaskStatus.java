package com.rwby.mytask.enum_type;

public enum TaskStatus {
    TASK_STATUS_TODO(0, "待完成"),
    TASK_STATUS_COMPLETED(1, "已完成"),
    TASK_STATUS_OVERDUE(2, "已逾期");
    public final int code;

    public final String name;

    TaskStatus(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
