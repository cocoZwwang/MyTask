package com.rwby.mytask.repository;

import com.rwby.mytask.annotation.Local;
import com.rwby.mytask.repository.local.TaskLocalDataSource;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class RepositoryModule {

    @Singleton
    @Binds
    @Local
    public abstract TaskDataSource provideLocalTaskDataSource(TaskLocalDataSource taskLocalDataSource);

}
