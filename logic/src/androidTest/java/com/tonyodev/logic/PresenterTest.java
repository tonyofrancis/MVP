package com.tonyodev.logic;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.tonyodev.User;
import com.tonyodev.core.dagger.AppModule;
import com.tonyodev.logic.interactor.MainInteractor;
import com.tonyodev.logic.interactor.MainInteractorImpl;
import com.tonyodev.logic.presenter.MainPresenter;
import com.tonyodev.logic.view.NameListView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Created by tonyofrancis on 4/14/17.
 */

@RunWith(AndroidJUnit4.class)
public class PresenterTest {

    private AppModule appModule;
    private MainPresenter mainPresenter;

    @Before
    public void setUp() {

        Context appContext = InstrumentationRegistry.getTargetContext();
        appModule = new AppModule(appContext);

        SharedPreferences sharedPreferences = appModule.provideSettingsSharedPreferences(appModule.provideContext());
        MainInteractor interactor = new MainInteractorImpl(appModule.provideContext(),sharedPreferences);

         mainPresenter = new MainPresenter(interactor,appModule.provideContext());
    }


    @Test
    public void mainPresenterUpdateNames() {

        mainPresenter.bind(new NameListView() {
            @Override
            public void onUpdateNameView(User[] names) {

                Assert.assertNotNull(names);
                Assert.assertThat(names[0].getName(),is(equalTo("Yahoo")));
            }
        });

        Assert.assertTrue(mainPresenter.isViewAttached());

        mainPresenter.updateNames(R.array.test_names);
    }
}
