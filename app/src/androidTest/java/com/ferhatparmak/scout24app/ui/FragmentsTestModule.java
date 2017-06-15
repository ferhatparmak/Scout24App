package com.ferhatparmak.scout24app.ui;

import com.ferhatparmak.scout24app.ui.colors.ColorsFragment;
import com.ferhatparmak.scout24app.ui.colors.ColorsTestModule;
import com.ferhatparmak.scout24app.ui.scope.FragmentScope;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@SuppressWarnings("unused") @Module public abstract class FragmentsTestModule {
  @FragmentScope
  @ContributesAndroidInjector(modules = ColorsTestModule.class)
  abstract ColorsFragment contributesColorsFragmentInjector();
}
