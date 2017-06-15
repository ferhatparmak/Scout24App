package com.ferhatparmak.scout24app.ui.colors;

import com.ferhatparmak.scout24app.ui.scope.FragmentScope;
import dagger.Module;
import dagger.Provides;
import org.mockito.Mockito;

@Module public abstract class ColorsTestModule {
  @Provides
  @FragmentScope
  static ColorsPresenter provideMockColorsPresenter() {
    return Mockito.mock(ColorsPresenter.class);
  }
}
