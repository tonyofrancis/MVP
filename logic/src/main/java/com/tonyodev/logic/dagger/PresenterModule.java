package com.tonyodev.logic.dagger;

import android.content.Context;
import android.content.SharedPreferences;

import com.tonyodev.logic.interactor.MainInteractor;
import com.tonyodev.logic.interactor.MainInteractorImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tonyofrancis on 4/13/17.
 */
@Module
public class PresenterModule {

    @Provides
    public MainInteractor getMainInteractor(Context context, SharedPreferences sharedPreferences) {
        return new MainInteractorImpl(context,sharedPreferences);
    }


}
