package com.tonyodev.logic;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.test.InstrumentationRegistry;

import com.tonyodev.core.dagger.AppModule;
import com.tonyodev.logic.interactor.MainInteractor;
import com.tonyodev.logic.interactor.MainInteractorImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by tonyofrancis on 4/14/17.
 */

public class InteractorTest {

    private AppModule appModule;
    private MainInteractor mainInteractor;

    @Before
    public void setUp() {

        Context appContext = InstrumentationRegistry.getTargetContext();
        appModule = new AppModule(appContext);

        SharedPreferences sharedPreferences = appModule.provideSettingsSharedPreferences(appModule.provideContext());
        mainInteractor = new MainInteractorImpl(appModule.provideContext(),sharedPreferences);
    }

    @Test
    public void getNames() {

       String[] names = mainInteractor.getNames(R.array.test_names);

       Assert.assertNotNull(names);
    }
}
