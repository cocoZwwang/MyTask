package com.rwby.mytask.repository;

import com.rwby.mytask.annotation.Local;
import com.rwby.mytask.bean.Task;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

@Singleton
public class TaskRepository implements TaskDataSource {
    private final TaskDataSource localDataSource;

    @Inject
    public TaskRepository(@Local TaskDataSource localDataSource) {
        this.localDataSource = localDataSource;
    }

    @Override
    public void save(Task task) {

    }

    @Override
    public void save(List<Task> tasks) {

    }

    @Override
    public int delete(int taskId) {
        return 0;
    }

    @Override
    public int delete(int[] taskIds) {
        return 0;
    }

    @Override
    public Observable<Task> getTask(int taskId) {
        return null;
    }

    @Override
    public Observable<List<Task>> getAllTasks() {
        return null;
    }
}
