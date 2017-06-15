package com.ferhatparmak.scout24app.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ColorData implements Parcelable {
  private final int color;

  public ColorData(int color) {
    this.color = color;
  }

  public int getColor() {
    return color;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(this.color);
  }

  protected ColorData(Parcel in) {
    this.color = in.readInt();
  }

  public static final Parcelable.Creator<ColorData> CREATOR = new Parcelable.Creator<ColorData>() {
    @Override
    public ColorData createFromParcel(Parcel source) {
      return new ColorData(source);
    }

    @Override
    public ColorData[] newArray(int size) {
      return new ColorData[size];
    }
  };
}
