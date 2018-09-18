package com.rwby.mytask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rwby.mytask.db.DatabaseHelper;
import com.rwby.mytask.util.SharedPref;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.schedulers.Schedulers;

@Module
public class DataUtilModule {
    @Provides
    @Singleton
    public Gson provideGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd hh:mm:ss")
                .create();
    }

    @Provides
    @Singleton
    public SharedPref providePreference(MyApp app) {
        return new SharedPref(app, "my_task_shared.xml");
    }

    @Provides
    @Singleton
    public BriteDatabase provideBriteDatabase(MyApp app) {
        DatabaseHelper dbHelper = new DatabaseHelper(app, "my_task.db");
        SqlBrite sqlBrite = SqlBrite.create();
        return sqlBrite.wrapDatabaseHelper(dbHelper, Schedulers.io());
    }
}