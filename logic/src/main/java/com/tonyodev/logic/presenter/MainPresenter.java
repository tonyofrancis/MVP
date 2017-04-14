package com.tonyodev.logic.presenter;

import android.content.Context;
import android.support.annotation.ArrayRes;

import com.tonyodev.User;
import com.tonyodev.core.base.BasePresenter;
import com.tonyodev.core.base.BaseView;
import com.tonyodev.logic.interactor.MainInteractor;
import com.tonyodev.logic.view.NameListView;

import javax.inject.Inject;

/**
 * Created by tonyofrancis on 4/13/17.
 */

public class MainPresenter implements BasePresenter {

    private final MainInteractor mainInteractor;
    private final Context context;

    private NameListView nameListView;

    @Inject
    public MainPresenter(MainInteractor mainInteractor,Context context) {
        this.mainInteractor = mainInteractor;
        this.context = context;
    }

    public void bind(BaseView baseView) {
        this.nameListView = (NameListView)baseView;
    }

    public void unbind() {
        nameListView = null;
    }

    public void updateNames(@ArrayRes int namesArray) {

        String[] names = mainInteractor.getNames(namesArray);
        User[] users = new User[names.length];

        for (int i = 0; i < names.length; i++) {
            users[i] = new User(names[i]);
        }

        nameListView.onUpdateNameView(users);
    }

    @Override
    public boolean isViewAttached() {

        return nameListView != null;
    }
}
