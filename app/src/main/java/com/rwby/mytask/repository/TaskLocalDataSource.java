package com.rwby.mytask.repository;

import com.rwby.mytask.bean.Task;
import com.squareup.sqlbrite.BriteDatabase;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Observable;

@Singleton
public class TaskLocalDataSource implements TaskDataSource {

    private final BriteDatabase mDatabaseHelper;

    @Inject
    public TaskLocalDataSource(BriteDatabase mDatabaseHelper) {
        this.mDatabaseHelper = mDatabaseHelper;
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
