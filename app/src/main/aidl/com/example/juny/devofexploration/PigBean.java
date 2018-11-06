package com.example.juny.devofexploration;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 自定义跨进程通信的数据类型
 * @author ChenRunFang
 */
public class PigBean implements Parcelable {
    public String name;
    public String weight;

    public PigBean(String name, String weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(weight);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PigBean> CREATOR = new Creator<PigBean>() {
        @Override
        public PigBean createFromParcel(Parcel in) {
            return new PigBean(in.readString(),in.readString());
        }

        @Override
        public PigBean[] newArray(int size) {
            return new PigBean[size];
        }
    };
}
