package com.ferhatparmak.scout24app;

import com.ferhatparmak.scout24app.ui.FragmentsTestModule;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = { FragmentsTestModule.class, AndroidSupportInjectionModule.class })
interface ApplicationTestComponent {
  void inject(Scout24TestApplication application);
}
