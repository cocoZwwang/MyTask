package com.rwby.mytask.tasks;

import com.rwby.mytask.annotation.FragmentScoped;
import com.rwby.mytask.bean.Task;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

@FragmentScoped
public class TasksPresenter implements TasksContract.Presenter {

    private final TasksContract.View mView;

    private List<Task> tasks;

    @Inject
    public TasksPresenter(TasksContract.View view) {
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

        tasks.add(new Task("linux课程学习","",false));
        tasks.add(new Task("减肥运动","",false));
        tasks.add(new Task("搞卫生","",true));
    }
}
