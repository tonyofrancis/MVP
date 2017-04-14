package com.tonyodev.myapp.dagger;

import com.tonyodev.myapp.main.MainActivity;

/**
 * Created by tonyofrancis on 4/13/17.
 */


public interface ActivityComponent {

    void inject(MainActivity mainActivity);
}
