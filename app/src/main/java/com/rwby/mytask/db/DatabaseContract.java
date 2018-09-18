package com.rwby.mytask.db;

import android.provider.BaseColumns;

public class DatabaseContract {
    private static final String TEXT_TYPE = " TEXT";

    private static final String INTEGER_TYPE = " INTEGER";

    private static final String LONG_TYPE = " LONG";

    private static final String UNIQUE = " UNIQUE";

    private static final String COMMA_SEP = ",";

    private DatabaseContract() {
    }

    public abstract static class TaskEntry implements BaseColumns {
        public static final String TABLE_NAME = "tasks";

        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_CONTENT = "content";
        public static final String COLUMN_COMPLETED_TAG = "completed_tag";
        public static final String COLUMN_CREATE_TIME = "create_time";
        public static final String COLUMN_UPDATE_TIME = "update_time";
        public static final String COLUMN_TASK_START_TIME = "task_start_time";
        public static final String COLUMN_TASK_END_TIME = "task_end_time";
        public static final String COLUMN_PERFORM_CYCLE = "perform_cycle";

        protected static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                _ID + TEXT_TYPE + " PRIMARY KEY," +
                COLUMN_TITLE + TEXT_TYPE + COMMA_SEP +
                COLUMN_CONTENT + TEXT_TYPE + COMMA_SEP +
                COLUMN_COMPLETED_TAG + INTEGER_TYPE + COMMA_SEP +
                COLUMN_CREATE_TIME + TEXT_TYPE + COMMA_SEP +
                COLUMN_UPDATE_TIME + TEXT_TYPE + COMMA_SEP +
                COLUMN_TASK_START_TIME + TEXT_TYPE + COMMA_SEP +
                COLUMN_TASK_END_TIME + TEXT_TYPE + COMMA_SEP +
                COLUMN_PERFORM_CYCLE + INTEGER_TYPE +
                " )";
    }
}
