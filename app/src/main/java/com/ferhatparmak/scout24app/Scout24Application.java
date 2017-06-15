package com.ferhatparmak.scout24app;

import android.app.Application;
import android.support.v4.app.Fragment;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import javax.inject.Inject;

public class Scout24Application extends Application implements HasSupportFragmentInjector {
  @Inject DispatchingAndroidInjector<Fragment> androidInjector;

  @Override
  public void onCreate() {
    super.onCreate();
    DaggerApplicationComponent.create().inject(this);
  }

  @Override
  public AndroidInjector<Fragment> supportFragmentInjector() {
    return androidInjector;
  }
}
