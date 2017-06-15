package com.ferhatparmak.scout24app;

import com.ferhatparmak.scout24app.ui.FragmentsModule;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@SuppressWarnings("unused")
@Component(modules = { FragmentsModule.class, AndroidSupportInjectionModule.class })
interface ApplicationComponent {
  void inject(Scout24Application application);
}
