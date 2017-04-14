package com.tonyodev.core.dagger;

import android.content.Context;
import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tonyofrancis on 4/13/17.
 */

@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    public SharedPreferences provideSettingsSharedPreferences(Context context){
        return context.getSharedPreferences("Settings", Context.MODE_PRIVATE);
    }
}
