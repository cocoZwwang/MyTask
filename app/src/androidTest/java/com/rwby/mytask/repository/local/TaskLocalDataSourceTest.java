package com.rwby.mytask.repository.local;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.rwby.mytask.DataUtilModuleTest;
import com.rwby.mytask.db.domain.Task;
import com.rwby.mytask.enum_type.TaskStatus;
import com.rwby.mytask.enum_type.TaskType;
import com.rwby.mytask.log.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

@RunWith(AndroidJUnit4.class)
public class TaskLocalDataSourceTest {

    TaskLocalDataSource taskLocalDataSource;

    CompositeSubscription compositeSubscription;

    @Before
    public void init() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        compositeSubscription = new CompositeSubscription();
        taskLocalDataSource = new TaskLocalDataSource(DataUtilModuleTest.provideDaoSession(appContext));
    }

    @After
    public void releaseSubscription() {
        if (compositeSubscription.hasSubscriptions())
            compositeSubscription.clear();
    }


    @Test
    public void save() {
        Task task = new Task();
        task.setTitle("测试1");
        task.setContent("测试-------------");
        Subscription subscription = taskLocalDataSource.save(task)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Task>() {
                    @Override
                    public void onCompleted() {
                        Logger.i("task添加结束");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.i("task添加失败：" + e.getMessage());
                    }

                    @Override
                    public void onNext(Task task) {
                        Logger.i("task：" + task.getTitle() + " 添加成功");
                    }
                });
        compositeSubscription.add(subscription);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void saveList() {
        List<Task> taskList = new ArrayList<>();
        long time = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Task task = new Task();
            task.setTitle("测试：" + i);
            task.setContent("测试：" + i);
            long t = time + 1000 * 60 * i;
            task.setCreateTime(new Date(t));
            task.setStatus(i % 3);
            task.setType(i % 2);
            taskList.add(task);
        }
        Subscription subscription = taskLocalDataSource.save(taskList)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Task>>() {
                    @Override
                    public void onCompleted() {
                        Logger.i("task添加结束");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.i("task添加失败：" + e.getMessage());
                    }

                    @Override
                    public void onNext(List<Task> tasks) {
                        Logger.i("tasks size：" + tasks.size() + " 添加成功");
                    }
                });
        compositeSubscription.add(subscription);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delete() {
        Subscription subscription = taskLocalDataSource.delete(1L)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Void>() {
                    @Override
                    public void onCompleted() {
                        Logger.i("task删除结束");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.i("task删除失败：" + e.getMessage());
                    }

                    @Override
                    public void onNext(Void v) {
                        Logger.i("tasks  删除成功");
                    }
                });
        compositeSubscription.add(subscription);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteList() {
        List<Long> longs = new ArrayList<>();
        for (long i = 0; i < 10000; i++) {
            longs.add(i);
        }
        Subscription subscription = taskLocalDataSource.delete(longs)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Void>() {
                    @Override
                    public void onCompleted() {
                        Logger.i("task删除结束");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.i("task删除失败：" + e.getMessage());
                    }

                    @Override
                    public void onNext(Void v) {
                        Logger.i("tasks  删除成功");
                    }
                });
        compositeSubscription.add(subscription);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deleteAll() {
        Subscription subscription = taskLocalDataSource.deleteAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Void>() {
                    @Override
                    public void onCompleted() {
                        Logger.i("task删除结束");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.i("task删除失败：" + e.getMessage());
                    }

                    @Override
                    public void onNext(Void v) {
                        Logger.i("tasks  删除成功");
                    }
                });
        compositeSubscription.add(subscription);
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTask() {
        Subscription subscription = taskLocalDataSource.getTask(1L)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Task>() {
                    @Override
                    public void onCompleted() {
                        Logger.i("task查询结束");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.i("task查询失败：" + e.getMessage());
                    }

                    @Override
                    public void onNext(Task task) {
                        Logger.i("task：" + task.getTitle() + " 查询成功");
                    }
                });
        compositeSubscription.add(subscription);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTasksSortByCreateTime() {
        Subscription subscription = taskLocalDataSource.getTasksSortByCreateTime(1, 101)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Task>>() {
                    @Override
                    public void onCompleted() {
                        Logger.i("task查询结束");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.i("task查询失败：" + e.getMessage());
                    }

                    @Override
                    public void onNext(List<Task> tasks) {
                        Logger.i("task查询成功 size：" + tasks.size());
                        for (Task task : tasks) {
                            Logger.i(task.toString());
                        }
                    }
                });
        compositeSubscription.add(subscription);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTasksSortByCreateTime1() {
        Subscription subscription = taskLocalDataSource.getTasksSortByCreateTime(TaskStatus.TASK_STATUS_OVERDUE, TaskType.TASK_TYPE_WEEK,1, 101)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Task>>() {
                    @Override
                    public void onCompleted() {
                        Logger.i("task查询结束");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.i("task查询失败：" + e.getMessage());
                    }

                    @Override
                    public void onNext(List<Task> tasks) {
                        Logger.i("task查询成功 size：" + tasks.size());
                        for (Task task : tasks) {
                            Logger.i(task.toString());
                        }
                    }
                });
        compositeSubscription.add(subscription);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}