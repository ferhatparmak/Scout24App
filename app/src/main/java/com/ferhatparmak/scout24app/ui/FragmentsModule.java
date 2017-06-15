package com.ferhatparmak.scout24app.ui;

import com.ferhatparmak.scout24app.ui.colors.ColorsFragment;
import com.ferhatparmak.scout24app.ui.colors.ColorsModule;
import com.ferhatparmak.scout24app.ui.scope.FragmentScope;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@SuppressWarnings("unused") @Module public abstract class FragmentsModule {
  @FragmentScope
  @ContributesAndroidInjector(modules = {
      ColorsModule.class
  })
  abstract ColorsFragment contributesColorsFragmentInjector();
}
