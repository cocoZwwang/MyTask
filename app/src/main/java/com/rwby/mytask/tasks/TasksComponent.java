package com.rwby.mytask.tasks;


import com.rwby.mytask.annotation.FragmentScoped;

import dagger.Component;

@FragmentScoped
@Component(modules = TasksMoudle.class)
public interface TasksComponent {
    void inject(TasksActivity activity);
}
