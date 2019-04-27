package com.rwby.mytask.repository.impl;

import com.rwby.mytask.annotation.Local;
import com.rwby.mytask.db.domain.Task;
import com.rwby.mytask.enum_type.TaskStatus;
import com.rwby.mytask.enum_type.TaskType;
import com.rwby.mytask.repository.TaskDataSource;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

@Singleton
public class TaskRepository implements TaskDataSource {
    private final TaskDataSource localDataSource;

    @Inject
    TaskRepository(@Local TaskDataSource localDataSource) {
        this.localDataSource = localDataSource;
    }


    @Override
    public Observable<Task> save(Task task) {
        return localDataSource.save(task);
    }

    @Override
    public Observable<List<Task>> save(List<Task> tasks) {
        return localDataSource.save(tasks);
    }

    @Override
    public Observable<Void> delete(Long taskId) {
        return localDataSource.delete(taskId);
    }

    @Override
    public Observable<Void> delete(List<Long> taskIds) {
        return localDataSource.delete(taskIds);
    }

    @Override
    public Observable<Void> deleteAll() {
        return localDataSource.deleteAll();
    }

    @Override
    public Observable<Task> getTask(Long taskId) {
        return localDataSource.getTask(taskId);
    }

    @Override
    public Observable<List<Task>> getTasksSortByCreateTime(int page, int pageSize) {
        return localDataSource.getTasksSortByCreateTime(page, pageSize);
    }

    @Override
    public Observable<List<Task>> getTasksSortByCreateTime(TaskStatus status, TaskType type, int page, int pageSize) {
        return localDataSource.getTasksSortByCreateTime(status, type, page, pageSize);
    }
}
