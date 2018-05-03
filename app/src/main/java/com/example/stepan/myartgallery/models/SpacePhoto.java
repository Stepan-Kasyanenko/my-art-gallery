package com.example.stepan.myartgallery.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class SpacePhoto implements Parcelable {

    private String mUrl;
    private String mTitle;

    private static SpacePhoto[] photos = {
            new SpacePhoto("http://i.imgur.com/zuG2bGQ.jpg", "Galaxy"),
            new SpacePhoto("http://i.imgur.com/ovr0NAF.jpg", "Space Shuttle"),
            new SpacePhoto("http://i.imgur.com/n6RfJX2.jpg", "Galaxy Orion"),
            new SpacePhoto("http://i.imgur.com/qpr5LR2.jpg", "Earth"),
            new SpacePhoto("http://i.imgur.com/pSHXfu5.jpg", "Astronaut"),
            new SpacePhoto("http://i.imgur.com/3wQcZeY.jpg", "Satellite"),
            new SpacePhoto("http://i.imgur.com/3wQcZeY.jpg", "Satellite"),
            new SpacePhoto("http://i.imgur.com/3wQcZeY.jpg", "Satellite"),
            new SpacePhoto("http://i.imgur.com/3wQcZeY.jpg", "Satellite"),
            new SpacePhoto("http://i.imgur.com/3wQcZeY.jpg", "Satellite"),
            new SpacePhoto("http://i.imgur.com/3wQcZeY.jpg", "Satellite"),
            new SpacePhoto("http://i.imgur.com/3wQcZeY.jpg", "Satellite"),
            new SpacePhoto("http://i.imgur.com/zuG2bGQ.jpg", "Galaxy"),
            new SpacePhoto("http://i.imgur.com/ovr0NAF.jpg", "Space Shuttle"),
            new SpacePhoto("http://i.imgur.com/n6RfJX2.jpg", "Galaxy Orion"),
            new SpacePhoto("http://i.imgur.com/qpr5LR2.jpg", "Earth"),
            new SpacePhoto("http://i.imgur.com/pSHXfu5.jpg", "Astronaut"),
    };

    public SpacePhoto(String url, String title) {
        mUrl = url;
        mTitle = title;
    }

    protected SpacePhoto(Parcel in) {
        mUrl = in.readString();
        mTitle = in.readString();
    }

    public static final Creator<SpacePhoto> CREATOR = new Creator<SpacePhoto>() {
        @Override
        public SpacePhoto createFromParcel(Parcel in) {
            return new SpacePhoto(in);
        }

        @Override
        public SpacePhoto[] newArray(int size) {
            return new SpacePhoto[size];
        }
    };

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public static ArrayList<SpacePhoto> getSpacePhotos() {
        return new ArrayList<>(Arrays.asList(photos));
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mUrl);
        parcel.writeString(mTitle);
    }
}