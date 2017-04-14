package com.tonyodev.logic.interactor;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.ArrayRes;

import javax.inject.Inject;

/**
 * Created by tonyofrancis on 4/13/17.
 */

public class MainInteractorImpl implements MainInteractor {

    private final Context context;
    private SharedPreferences sharedPreferences;

    @Inject
    public MainInteractorImpl(Context context, SharedPreferences sharedPreferences) {
        this.context = context;
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public String[] getNames(@ArrayRes int names) {
        return context.getResources().getStringArray(names);
    }
}
