package com.rwby.mytask.log;

import android.util.Log;

import com.rwby.mytask.BuildConfig;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 *
 */
public class Logger {
    public static boolean logdog = false;
    public static String TAG = "My_Task";

    /**
     * @param tag
     * @param msg
     */
    static public void d(String tag, String msg) {
        try {
            if (BuildConfig.DEBUG) {
                if (msg == null) {
                    msg = "null";
                }
                Log.d(tag, msg);
                if (logdog)
                    Logdog.d(msg);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    /**
     * @param tag
     * @param msg
     */
    static public void i(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            if (msg == null) {
                msg = "null";
            }
            Log.i(tag, msg);
            if (logdog)
                Logdog.i(msg);
        }
    }

    /**
     * @param tag
     * @param msg
     */
    static public void e(String tag, String msg) {
        if (BuildConfig.DEBUG) {
            if (msg == null) {
                msg = "null";
            }
            Log.e(tag, msg);
            if (logdog)
                Logdog.e(msg);
        }
    }

    /**
     * @param log
     */
    static public void d(String log) {
        if (BuildConfig.DEBUG) {
            if (log == null) {
                log = "null";
            }
            Log.d(TAG, log);
            if (logdog)
                Logdog.d(log);
        }
    }

    /**
     * @param log
     */
    static public void e(String log) {
        if (BuildConfig.DEBUG) {
            if (log == null) {
                log = "null";
            }
            Log.e(TAG, log);
            if (logdog)
                Logdog.e(log);
        }
    }

    /**
     * @param log
     */
    static public void i(String log) {
        if (BuildConfig.DEBUG) {
            if (log == null) {
                log = "null";
            }
            Log.i(TAG, log);
            if (logdog)
                Logdog.i(log);
        }
    }

    static public void e(Throwable e) {
        if (!BuildConfig.DEBUG) {
            return;
        }
        Logger.e("Error info:" + e.toString());
        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        e.printStackTrace(printWriter);
        Throwable cause = e.getCause();
        while (cause != null) {
            cause.printStackTrace(printWriter);
            cause = cause.getCause();
        }
        printWriter.close();
        String result = writer.toString();
        Logger.e("Cause Result:" + result);
    }
}
