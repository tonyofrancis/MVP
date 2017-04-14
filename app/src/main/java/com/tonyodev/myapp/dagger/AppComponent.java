package com.tonyodev.myapp.dagger;

import com.tonyodev.core.dagger.AppModule;
import com.tonyodev.core.dagger.ApplicationComponent;
import com.tonyodev.logic.dagger.PresenterModule;

import dagger.Component;

/**
 * Created by tonyofrancis on 4/13/17.
 */

@Component(modules = {AppModule.class,PresenterModule.class})
public interface AppComponent extends ActivityComponent,FragmentComponent,ApplicationComponent {

}
