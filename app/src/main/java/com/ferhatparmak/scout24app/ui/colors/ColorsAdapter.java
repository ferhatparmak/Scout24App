package com.ferhatparmak.scout24app.ui.colors;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.ferhatparmak.scout24app.R;
import com.ferhatparmak.scout24app.model.ColorData;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

public class ColorsAdapter extends RecyclerView.Adapter<ColorsAdapter.ColorViewHolder> {
  private List<ColorData> colors = Collections.emptyList();

  @Inject
  ColorsAdapter() {

  }

  @Override
  public ColorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    return new ColorViewHolder(layoutInflater.inflate(R.layout.item_color, parent, false));
  }

  @Override
  public void onBindViewHolder(ColorViewHolder holder, int position) {
    ColorData color = colors.get(position);
    holder.colorCarcView.setBackgroundColor(color.getColor());
  }

  @Override
  public int getItemCount() {
    return colors.size();
  }

  void updateItems(List<ColorData> colors) {
    this.colors = colors;
    notifyDataSetChanged();
  }

  static class ColorViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.cv_color) CardView colorCarcView;

    ColorViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }

  public List<ColorData> getColors() {
    return colors;
  }
}
