/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.tonyodev.mytvapp.main;

import android.os.Bundle;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;

import com.tonyodev.User;
import com.tonyodev.logic.presenter.MainPresenter;
import com.tonyodev.logic.view.NameListView;
import com.tonyodev.mytvapp.R;
import com.tonyodev.mytvapp.base.PresenterBrowseFragment;
import com.tonyodev.mytvapp.dagger.AppComponent;


public class MainFragment extends PresenterBrowseFragment<MainPresenter> implements NameListView {

    @Override
    public void onCreate(AppComponent appComponent, Bundle bundle) {
        appComponent.inject(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupUIElements();
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.bind(this);
        presenter.updateNames(R.array.tv_names);
    }

    @Override
    public void onUpdateNameView(User[] users) {
        loadRows(users);
    }

    private void loadRows(User[] users) {

        ArrayObjectAdapter mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new UserPresenter());

        for (User user : users) {
            listRowAdapter.add(user);
        }

        mRowsAdapter.add(new ListRow(new HeaderItem("Users"),listRowAdapter));

        setAdapter(mRowsAdapter);
    }

    private void setupUIElements() {

        setTitle(getString(R.string.browse_title));
        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true);
        setBrandColor(getResources().getColor(R.color.colorPrimary));
        setSearchAffordanceColor(getResources().getColor(R.color.colorAccent));
    }
}
