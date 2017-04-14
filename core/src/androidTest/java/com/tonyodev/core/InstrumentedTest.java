package com.tonyodev.core;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.tonyodev.core.dagger.AppModule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class InstrumentedTest {

    private AppModule appModule;

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.tonyodev.core.test", appContext.getPackageName());
    }

    @Before
    public void setUp() {

        Context appContext = InstrumentationRegistry.getTargetContext();
        appModule = new AppModule(appContext);
    }

    @Test
    public void getApplicationContext() {
        Assert.assertNotNull(appModule.provideContext());
    }

    @Test
    public void getSettingsSharedPreferences() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        Assert.assertNotNull(appModule.provideSettingsSharedPreferences(appContext));
    }
}
