package com.rwby.mytask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rwby.mytask.db.domain.DaoMaster;
import com.rwby.mytask.db.domain.DaoSession;
import com.rwby.mytask.util.SharedPref;

import org.greenrobot.greendao.database.Database;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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
    public DaoSession provideDaoSession(MyApp app) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(app, "task_db");
        Database db = helper.getWritableDb();
        return new DaoMaster(db).newSession();
    }
}
