package com.ferhatparmak.scout24app;

import com.ferhatparmak.scout24app.model.ColorData;
import com.ferhatparmak.scout24app.model.ColorsModel;
import com.ferhatparmak.scout24app.ui.colors.ColorsPresenter;
import com.ferhatparmak.scout24app.ui.colors.ColorsView;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ColorsPresenterTest {
  private ColorsPresenter colorsPresenter;
  @Mock ColorsView colorsView;
  @Mock ColorsModel colorsModel;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    colorsPresenter = new ColorsPresenter(colorsView, colorsModel);
  }

  @Test
  public void loadColors_whenColorsFetched_thenCallShowColorsOfView() {
    List<ColorData> testColors = new ArrayList<>();
    Mockito.when(colorsModel.colors()).thenReturn(Single.just(testColors));
    colorsPresenter.loadColors();
    Mockito.verify(colorsView).showColors(testColors);
  }
}
