package com.iteso.vizkar_v1.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class eventos implements Parcelable {

    private int id;
    private String picture;
    private String name;
    private String type;
    private String city;
    private String timestamp;

    public eventos(){

    }

    public eventos(int id, String name, String type, String city){
        this.id = id;
        this.name = name;
        this.type = type;
        this.city = city;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.picture);
        dest.writeString(this.name);
        dest.writeString(this.type);
        dest.writeString(this.city);
        dest.writeString(this.timestamp);
    }

    protected eventos(Parcel in) {
        this.id = in.readInt();
        this.picture = in.readString();
        this.name = in.readString();
        this.type = in.readString();
        this.city = in.readString();
        this.timestamp = in.readString();
    }


    public static final Parcelable.Creator<eventos> CREATOR = new Parcelable.Creator<eventos>() {
        @Override
        public eventos createFromParcel(Parcel source) {
            return new eventos(source);
        }

        @Override
        public eventos[] newArray(int size) {
            return new eventos[size];
        }
    };
}
