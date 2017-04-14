package com.tonyodev.mytvapp;

import android.app.Application;

import com.tonyodev.core.dagger.AppModule;
import com.tonyodev.mytvapp.dagger.AppComponent;
import com.tonyodev.mytvapp.dagger.DaggerAppComponent;


/**
 * Created by tonyofrancis on 4/13/17.
 */

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        createAppComponent();
    }

    private void createAppComponent() {

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
