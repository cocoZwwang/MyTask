package com.rwby.mytask;

import android.app.Application;

import com.facebook.stetho.Stetho;

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

        dependenciesComponent = DaggerDependenciesComponent
                .builder()
                .appModule(new AppModule(this))
                .dataUtilModule(new DataUtilModule())
                .build();

        Stetho.initializeWithDefaults(this);
    }

    public DependenciesComponent getDependenciesComponent() {
        return dependenciesComponent;
    }
}
