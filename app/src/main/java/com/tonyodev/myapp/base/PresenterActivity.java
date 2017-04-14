package com.tonyodev.myapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tonyodev.core.base.BaseActivity;
import com.tonyodev.core.base.BasePresenter;
import com.tonyodev.myapp.App;
import com.tonyodev.myapp.dagger.AppComponent;

import javax.inject.Inject;

/**
 * Created by tonyofrancis on 4/13/17.
 */

public abstract class PresenterActivity<T extends BasePresenter> extends AppCompatActivity
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
