package com.ferhatparmak.scout24app.ui.colors;

import com.ferhatparmak.scout24app.model.ColorData;
import com.ferhatparmak.scout24app.model.ColorsModel;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import javax.inject.Inject;

public class ColorsPresenter {
  private final ColorsView colorsView;
  private final ColorsModel colorsModel;
  private Disposable disposable;

  @Inject
  public ColorsPresenter(ColorsView colorsView, ColorsModel colorsModel) {
    this.colorsView = colorsView;
    this.colorsModel = colorsModel;
  }

  public void loadColors() {
    disposable = colorsModel.colors().subscribe(new Consumer<List<ColorData>>() {
      @Override
      public void accept(@NonNull List<ColorData> colors) throws Exception {
        colorsView.showColors(colors);
      }
    });
  }

  void detach() {
    if (disposable != null && !disposable.isDisposed()) {
      disposable.dispose();
      disposable = null;
    }
  }
}
