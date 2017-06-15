package com.ferhatparmak.scout24app.ui.colors;

import android.graphics.Color;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.ferhatparmak.scout24app.R;
import com.ferhatparmak.scout24app.model.ColorData;
import com.ferhatparmak.scout24app.ui.main.MainActivity;
import com.ferhatparmak.scout24app.util.Matchers;
import com.ferhatparmak.scout24app.util.RecyclerViewMatcher;
import java.util.ArrayList;
import java.util.List;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

@RunWith(AndroidJUnit4.class) public class ColorsFragmentTest {
  @Rule public ActivityTestRule<MainActivity> activityRule =
      new ActivityTestRule<>(MainActivity.class, true, true);

  @Test
  public void color_whenShowColorIsCalledWithRed_ThenShouldShowRed() throws Throwable {
    final List<ColorData> colorDatas = new ArrayList<>();
    colorDatas.add(new ColorData(Color.RED));
    activityRule.runOnUiThread(new Runnable() {
      @Override
      public void run() {
        ColorsFragment colorsFragment = (ColorsFragment) activityRule.getActivity()
            .getSupportFragmentManager()
            .findFragmentById(R.id.fragment_colors);
        colorsFragment.showColors(colorDatas);
      }
    });

    onView(new RecyclerViewMatcher(R.id.rv_colors_list).atPosition(0)).check(
        matches(Matchers.withBackgroundColor(Color.RED)));
  }
}
