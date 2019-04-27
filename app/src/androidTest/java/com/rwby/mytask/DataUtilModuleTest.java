package com.rwby.mytask;

import android.content.Context;

import com.rwby.mytask.db.domain.DaoMaster;
import com.rwby.mytask.db.domain.DaoSession;

import org.greenrobot.greendao.database.Database;

public class DataUtilModuleTest {

    public static DaoSession provideDaoSession(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "task_test_db");
        Database db = helper.getWritableDb();
        return new DaoMaster(db).newSession();
    }
}
