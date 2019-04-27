package com.rwby.mytask.repository.local;

import com.rwby.mytask.db.domain.DaoSession;
import com.rwby.mytask.db.domain.Task;
import com.rwby.mytask.db.domain.TaskDao;
import com.rwby.mytask.enum_type.TaskStatus;
import com.rwby.mytask.enum_type.TaskType;
import com.rwby.mytask.repository.TaskDataSource;

import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;
import org.greenrobot.greendao.rx.RxDao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

@Singleton
public class TaskLocalDataSource implements TaskDataSource {
    private final RxDao<Task, Long> taskRxDao;

    private final TaskDao taskDao;

    @Inject
    TaskLocalDataSource(DaoSession daoSession) {
        taskDao = daoSession.getTaskDao();
        taskRxDao = taskDao.rx();
    }

    @Override
    public Observable<Task> save(Task task) {
        return taskRxDao.insert(task);
    }

    @Override
    public Observable<List<Task>> save(List<Task> tasks) {
        return taskRxDao.insertInTx(tasks).flatMap(Observable::from).toList();
    }

    @Override
    public Observable<Void> delete(Long taskId) {
        return taskRxDao.deleteByKey(taskId);
    }

    @Override
    public Observable<Void> delete(List<Long> taskIds) {
        return taskRxDao.deleteByKeyInTx(taskIds);
    }

    @Override
    public Observable<Void> deleteAll() {
        return taskRxDao.deleteAll();
    }

    @Override
    public Observable<Task> getTask(Long taskId) {
        return taskRxDao.load(taskId);
    }

    @Override
    public Observable<List<Task>> getTasksSortByCreateTime(int page, int pageSize) {
        return getTasksSortByCreateTime(null, null, page, pageSize);
    }

    @Override
    public Observable<List<Task>> getTasksSortByCreateTime(TaskStatus status, TaskType type, int page, int pageSize) {
        WhereCondition whereCondition = null;
        WhereCondition whereMoreConditions = null;
        if (status != null)
            whereCondition = TaskDao.Properties.Status.eq(status.code);
        else if (type != null)
            whereCondition = TaskDao.Properties.Type.eq(type.code);
        if (status != null && type != null)
            whereMoreConditions = TaskDao.Properties.Type.eq(type.code);

        QueryBuilder<Task> countBuilder = taskDao.queryBuilder();
        QueryBuilder<Task> queryBuilder = taskDao.queryBuilder();
        if (whereCondition != null && whereMoreConditions != null) {
            countBuilder.where(whereCondition, whereMoreConditions);
            queryBuilder.where(whereCondition, whereMoreConditions);
        } else if (whereCondition != null) {
            countBuilder.where(whereCondition);
            queryBuilder.where(whereCondition);
        }

        long count = countBuilder.count();
        if (page == 0)
            return Observable.error(new IllegalArgumentException("page 小于 1"));
        int offset = (page - 1) * pageSize;
        if (offset > count)
            return Observable.error(new IllegalArgumentException("page * pageSize 不能大于 totalSize"));
        return queryBuilder
                .orderDesc(TaskDao.Properties.CreateTime)
                .offset(offset)
                .limit(pageSize)
                .rx()
                .list();
    }
}
