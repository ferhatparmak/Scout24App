package com.ferhatparmak.scout24app.ui.colors;

import dagger.Binds;
import dagger.Module;

@Module public abstract class ColorsModule {
  @Binds
  abstract ColorsView bindColorsView(ColorsFragment colorsFragment);
}
