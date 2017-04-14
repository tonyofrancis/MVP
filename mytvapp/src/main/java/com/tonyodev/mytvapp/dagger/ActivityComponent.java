package com.tonyodev.mytvapp.dagger;


import com.tonyodev.mytvapp.main.MainActivity;

/**
 * Created by tonyofrancis on 4/13/17.
 */


public interface ActivityComponent {

    void inject(MainActivity mainActivity);
}
