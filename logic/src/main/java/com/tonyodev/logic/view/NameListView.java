package com.tonyodev.logic.view;

import com.tonyodev.User;
import com.tonyodev.core.base.BaseView;

/**
 * Created by tonyofrancis on 4/13/17.
 */

public interface NameListView extends BaseView {

    void onUpdateNameView(User[] names);
}
