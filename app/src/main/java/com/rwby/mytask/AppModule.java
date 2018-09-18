package com.rwby.mytask;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final MyApp app;

    public AppModule(MyApp app) {
        this.app = app;
    }

    @Singleton
    @Provides
    public MyApp provideMyApp(){
        return app;
    }
}
