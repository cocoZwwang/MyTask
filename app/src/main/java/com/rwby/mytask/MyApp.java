package com.rwby.mytask;

import android.app.Application;

public class MyApp extends Application {
    private static MyApp INSTANCE;

    public static MyApp getInstance() {
        return INSTANCE;
    }

    private DependenciesComponent dependenciesComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;


    }

    public DependenciesComponent getDependenciesComponent() {
        return dependenciesComponent;
    }
}
