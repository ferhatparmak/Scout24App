package com.ferhatparmak.scout24app.util;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class Matchers {
  public static Matcher<View> withBackgroundColor(final int backgroundColor) {
    return new TypeSafeMatcher<View>() {

      @Override
      public boolean matchesSafely(View view) {
        int color = ((ColorDrawable) view.getBackground().getCurrent()).getColor();
        return color == backgroundColor;
      }

      @Override
      public void describeTo(Description description) {
        description.appendText("background color: " + backgroundColor);
      }
    };
  }
}
