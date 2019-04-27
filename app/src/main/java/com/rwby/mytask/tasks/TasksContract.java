package com.rwby.mytask.tasks;

import com.rwby.mytask.BasePresenter;
import com.rwby.mytask.BaseView;
import com.rwby.mytask.db.domain.Task;

import java.util.List;

/**
 * 任务日记列表
 * Created by 31304 on 2018/5/15.
 */
public interface TasksContract {

    interface Presenter extends BasePresenter {

    }

    interface View extends BaseView<Presenter> {
        void showTasks(List<Task> tasks);
    }
}
