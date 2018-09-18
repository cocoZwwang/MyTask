package com.rwby.mytask.tasks;


import com.rwby.mytask.DependenciesComponent;
import com.rwby.mytask.annotation.FragmentScoped;

import dagger.Component;

@FragmentScoped
@Component(dependencies = DependenciesComponent.class, modules = TasksMoudle.class)
public interface TasksComponent {
    void inject(TasksActivity activity);
}
