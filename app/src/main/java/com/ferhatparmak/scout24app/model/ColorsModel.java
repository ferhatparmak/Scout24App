package com.ferhatparmak.scout24app.model;

import android.graphics.Color;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;

public class ColorsModel {

  @Inject
  public ColorsModel() {
  }

  public Single<List<ColorData>> colors() {
    return Observable.range(1, 100000).map(new Function<Integer, ColorData>() {
      @Override
      public ColorData apply(@NonNull Integer integer) throws Exception {
        if (integer % 3 == 0 && integer % 5 == 0) {
          return new ColorData(Color.YELLOW);
        }

        if (integer % 3 == 0) {
          return new ColorData(Color.RED);
        }

        if (integer % 5 == 0) {
          return new ColorData(Color.BLUE);
        }

        return new ColorData(Color.BLACK);
      }
    }).toList();
  }
}
