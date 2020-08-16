package com.example.rebeikiacollector.utiles;

import android.app.Application;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        new InternetConnection(getApplicationContext());
    }
}
