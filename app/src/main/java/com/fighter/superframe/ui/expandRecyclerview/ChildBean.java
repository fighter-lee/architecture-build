package com.fighter.superframe.ui.expandRecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fighter_lee on 2017/10/17.
 */

public class ChildBean implements Parcelable {

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    private String desc;
    private String author;
    private String imageUrl;

    public ChildBean() {

    }

    protected ChildBean(Parcel in) {
        desc = in.readString();
        author = in.readString();
        imageUrl = in.readString();
    }

    public static final Creator<ChildBean> CREATOR = new Creator<ChildBean>() {
        @Override
        public ChildBean createFromParcel(Parcel in) {
            return new ChildBean(in);
        }

        @Override
        public ChildBean[] newArray(int size) {
            return new ChildBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(desc);
        dest.writeString(author);
        dest.writeString(imageUrl);
    }
}
