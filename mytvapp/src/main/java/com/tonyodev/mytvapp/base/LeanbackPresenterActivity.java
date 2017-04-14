package com.tonyodev.mytvapp.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.tonyodev.core.base.BaseActivity;
import com.tonyodev.core.base.BasePresenter;
import com.tonyodev.mytvapp.App;
import com.tonyodev.mytvapp.dagger.AppComponent;

import javax.inject.Inject;

/**
 * Created by tonyofrancis on 4/13/17.
 */

public abstract class LeanbackPresenterActivity<T extends BasePresenter> extends Activity
        implements BaseActivity {

    @Inject
    protected T presenter;

    abstract protected void onCreate(AppComponent appComponent, Bundle bundle);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppComponent appComponent = ((App) getApplication()).getAppComponent();
        onCreate(appComponent,savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unbind();
    }
}
