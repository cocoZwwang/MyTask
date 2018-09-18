package com.rwby.mytask;

import com.rwby.mytask.repository.RepositoryModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class,
        DataUtilModule.class,
        RepositoryModule.class})
public interface DependenciesComponent {

}
