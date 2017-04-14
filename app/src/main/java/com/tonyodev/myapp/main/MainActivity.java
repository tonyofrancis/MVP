package com.tonyodev.myapp.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tonyodev.User;
import com.tonyodev.myapp.base.PresenterActivity;
import com.tonyodev.logic.presenter.MainPresenter;
import com.tonyodev.logic.view.NameListView;
import com.tonyodev.myapp.R;
import com.tonyodev.myapp.dagger.AppComponent;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends PresenterActivity<MainPresenter> implements NameListView {

    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    private NamesAdapter namesAdapter;

    @Override
    protected void onCreate(AppComponent appComponent, Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        appComponent.inject(this);
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        namesAdapter = new NamesAdapter();
        recyclerView.setAdapter(namesAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.bind(this);
        presenter.updateNames(R.array.names);
    }

    @Override
    public void onUpdateNameView(User[] users) {
        namesAdapter.swap(users);
    }
}
