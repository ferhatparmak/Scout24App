package com.ferhatparmak.scout24app;

import android.graphics.Color;
import com.ferhatparmak.scout24app.model.ColorData;
import com.ferhatparmak.scout24app.model.ColorsModel;
import java.util.List;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class ColorsModelTest {
  private ColorsModel colorsModel;

  @Before
  public void setUp() {
    this.colorsModel = new ColorsModel();
  }

  @Test
  public void colors_whenSubscribed_thenThirdItemShouldBeRed() {
    List<ColorData> colorDatas = colorsModel.colors().test().values().get(0);
    Assert.assertEquals(colorDatas.get(2).getColor(), Color.RED);
  }

  @Test
  public void colors_whenSubscribed_thenFifthItemShouldBeBlue() {
    List<ColorData> colorDatas = colorsModel.colors().test().values().get(0);
    Assert.assertEquals(colorDatas.get(4).getColor(), Color.BLUE);
  }

  @Test
  public void colors_whenSubscribed_thenFifteenthItemShouldBeYellow() {
    List<ColorData> colorDatas = colorsModel.colors().test().values().get(0);
    Assert.assertEquals(colorDatas.get(14).getColor(), Color.YELLOW);
  }
}
