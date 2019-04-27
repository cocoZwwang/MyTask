package com.rwby.mytask.repository;

import com.rwby.mytask.db.domain.Task;
import com.rwby.mytask.enum_type.TaskStatus;
import com.rwby.mytask.enum_type.TaskType;

import java.util.List;

import rx.Observable;

public interface TaskDataSource {
    Observable<Task> save(Task task);

    Observable<List<Task>> save(List<Task> tasks);

    Observable<Void> delete(Long taskId);

    Observable<Void> delete(List<Long> taskIds);

    Observable<Void> deleteAll();

    Observable<Task> getTask(Long taskId);

    Observable<List<Task>> getTasksSortByCreateTime(int page, int pageSize);

    Observable<List<Task>> getTasksSortByCreateTime(TaskStatus status, TaskType type, int page, int pageSize);
}
