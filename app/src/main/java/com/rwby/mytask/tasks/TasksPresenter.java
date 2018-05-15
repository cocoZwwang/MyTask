package com.rwby.mytask.tasks;

import com.rwby.mytask.annotation.FragmentScoped;

import javax.inject.Inject;

@FragmentScoped
public class TasksPresenter implements TasksContract.Presenter {

    private final TasksContract.View mView;

    @Inject
    public TasksPresenter(TasksContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
