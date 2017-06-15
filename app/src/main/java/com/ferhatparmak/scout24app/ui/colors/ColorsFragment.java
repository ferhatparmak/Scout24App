package com.ferhatparmak.scout24app.ui.colors;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.ferhatparmak.scout24app.R;
import com.ferhatparmak.scout24app.model.ColorData;
import dagger.android.support.AndroidSupportInjection;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class ColorsFragment extends Fragment implements ColorsView {
  private static final String EXTRA_COLORS = "Colors";

  @BindView(R.id.rv_colors_list) RecyclerView colorsRecyclerView;
  @Inject ColorsPresenter colorsPresenter;
  @Inject ColorsAdapter colorsAdapter;
  private Unbinder unbinder;

  @Override
  public void onAttach(Context context) {
    AndroidSupportInjection.inject(this);
    super.onAttach(context);
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    if (colorsAdapter != null) {
      outState.putParcelableArrayList(EXTRA_COLORS,
          new ArrayList<Parcelable>(colorsAdapter.getColors()));
    }
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    final View view = inflater.inflate(R.layout.fragment_colors, container, false);
    unbinder = ButterKnife.bind(this, view);
    initColorsRecyclerView(view);
    return view;
  }

  private void initColorsRecyclerView(View view) {
    colorsRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    colorsRecyclerView.setAdapter(colorsAdapter);
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    if (savedInstanceState != null) {
      List<ColorData> savedColors = savedInstanceState.getParcelableArrayList(EXTRA_COLORS);
      if (savedColors != null) {
        colorsAdapter.updateItems(savedColors);
      } else {
        colorsPresenter.loadColors();
      }
    } else {
      colorsPresenter.loadColors();
    }
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    unbindViews();
    colorsPresenter.detach();
  }

  private void unbindViews() {
    if (unbinder != null) {
      unbinder.unbind();
      unbinder = null;
    }
  }

  @Override
  public void showColors(List<ColorData> colors) {
    colorsAdapter.updateItems(colors);
  }
}
