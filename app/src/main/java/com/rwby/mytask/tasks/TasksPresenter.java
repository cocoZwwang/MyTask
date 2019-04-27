package com.rwby.mytask.tasks;

import com.rwby.mytask.annotation.FragmentScoped;
import com.rwby.mytask.db.domain.Task;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

@FragmentScoped
public class TasksPresenter implements TasksContract.Presenter {

    private final TasksContract.View mView;

    private List<Task> tasks;

    @Inject
    TasksPresenter(TasksContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void start() {
        loadTasks();
        mView.showTasks(tasks);
    }

    private void loadTasks() {
        tasks = new ArrayList<>();

        tasks.add(getTask("linux课程学习"));
        tasks.add(getTask("减肥运动"));
        tasks.add(getTask("搞卫生"));
    }

    private Task getTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setContent("");
        task.setStatus(0);
        task.setType(0);
        task.setCompletedDate(null);
        return task;
    }
}
