package com.besome.sketch;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Process;
import android.util.Log;

import com.besome.sketch.tools.CollectErrorActivity;

import com.google.android.gms.analytics.Tracker;
import com.google.android.material.color.DynamicColors;

import mod.trindade.dev.theme.AppTheme; 

public class SketchApplication extends Application {

    private static Context mApplicationContext;
    private static AppTheme appThemeHelper;
    
    public static Context getContext() {
        return mApplicationContext;
    }

    public synchronized Tracker a() {
        return new Tracker();
    }

    @Override
    public void onCreate() {
        mApplicationContext = getApplicationContext();
        appThemeHelper = new AppTheme(this);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
            Log.e("SketchApplication", "Uncaught exception  thread " + thread.getName(), throwable);

            Intent intent = new Intent(getApplicationContext(), CollectErrorActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.putExtra("error", Log.getStackTraceString(throwable));
            ((AlarmManager) getSystemService(Context.ALARM_SERVICE))
                    .set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                            1000,
                            PendingIntent.getActivity(getApplicationContext(), 11111, intent,
                                    PendingIntent.FLAG_ONE_SHOT | PendingIntent.FLAG_IMMUTABLE));
            Process.killProcess(Process.myPid());
            System.exit(1);
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, throwable);
            }
        });
        super.onCreate();
        /*if (appThemeHelper.getDynamic()) {
            DynamicColors.applyToActivitiesIfAvailable(this);
        }*/
    }
}
