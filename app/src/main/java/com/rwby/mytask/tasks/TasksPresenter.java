package com.rwby.mytask.tasks;

import com.rwby.mytask.annotation.FragmentScoped;
import com.rwby.mytask.db.domain.Task;
import com.rwby.mytask.log.Logger;
import com.rwby.mytask.repository.impl.TaskRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

@FragmentScoped
public class TasksPresenter implements TasksContract.Presenter {

    private final TasksContract.View mView;

    private final TaskRepository taskRepository;

    private final CompositeSubscription compositeSubscription;

    @Inject
    TasksPresenter(TasksContract.View view, TaskRepository taskRepository) {
        mView = view;
        mView.setPresenter(this);
        this.taskRepository = taskRepository;
        compositeSubscription = new CompositeSubscription();
    }

    @Override
    public void start() {
        loadTasks();
    }

    private void loadTasks() {
        mView.showLoadingProgress(true);
        Subscription subscription = taskRepository
                .getTasksSortByCreateTime(1, 10)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Task>>() {
                    @Override
                    public void onCompleted() {
                        mView.showLoadingProgress(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.loadTaskError("加载任务失败");
                        Logger.i("加载任务失败：" + e.getMessage());
                        mView.showLoadingProgress(false);
                    }

                    @Override
                    public void onNext(List<Task> tasks) {
                        mView.showTasks(tasks);
                        mView.showLoadingProgress(false);
                    }
                });
        compositeSubscription.add(subscription);
    }

    @Override
    public void unSubscribe() {
        if (compositeSubscription.hasSubscriptions())
            compositeSubscription.clear();
    }

    //    private void loadTasks() {
//        tasks = new ArrayList<>();
//
//        tasks.add(getTask("linux课程学习"));
//        tasks.add(getTask("减肥运动"));
//        tasks.add(getTask("搞卫生"));
//    }
//
//    private Task getTask(String title) {
//        Task task = new Task();
//        task.setTitle(title);
//        task.setContent("");
//        task.setStatus(0);
//        task.setType(0);
//        task.setCompletedDate(null);
//        return task;
//    }
}
