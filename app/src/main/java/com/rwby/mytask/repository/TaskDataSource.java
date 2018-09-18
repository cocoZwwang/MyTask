package com.rwby.mytask.repository;

import com.rwby.mytask.bean.Task;

import java.util.List;

import rx.Observable;

public interface TaskDataSource {
    void save(Task task);

    void save(List<Task> tasks);

    int delete(int taskId);

    int delete(int[] taskIds);

    Observable<Task> getTask(int taskId);

    Observable<List<Task>> getAllTasks();
}
