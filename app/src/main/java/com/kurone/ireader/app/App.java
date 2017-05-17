package com.kurone.ireader.app;

import android.app.Application;

/**
 * Application child class. Created by Kurone on 2017/4/19.
 */

public class App extends Application{
    public static App app;
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
