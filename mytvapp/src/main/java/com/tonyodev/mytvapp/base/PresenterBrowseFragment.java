package com.tonyodev.mytvapp.base;

import android.os.Bundle;
import android.support.v17.leanback.app.BrowseFragment;

import com.tonyodev.core.base.BasePresenter;
import com.tonyodev.mytvapp.App;
import com.tonyodev.mytvapp.dagger.AppComponent;

import javax.inject.Inject;

/**
 * Created by tonyofrancis on 4/14/17.
 */

public abstract class PresenterBrowseFragment<T extends BasePresenter> extends BrowseFragment {

    @Inject
    protected T presenter;

    abstract public void onCreate(AppComponent appComponent, Bundle bundle);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppComponent appComponent = ((App) getActivity().getApplication()).getAppComponent();
        onCreate(appComponent,savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.unbind();
    }
}
