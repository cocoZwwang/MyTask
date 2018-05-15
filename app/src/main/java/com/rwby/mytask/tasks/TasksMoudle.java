package com.rwby.mytask.tasks;

import dagger.Module;
import dagger.Provides;

@Module
public class TasksMoudle {

    private final TasksContract.View view;


    public TasksMoudle(TasksContract.View view) {
        this.view = view;
    }

    @Provides
    public TasksContract.View provideTasksContractView() {
        return view;
    }

}
