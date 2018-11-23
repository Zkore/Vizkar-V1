package com.iteso.vizkar_v1.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class eventos implements Parcelable {

    private int id;
    private int picture;
    private String name;
    private String type;
    private String city;
    private String timestamp;
    //False = Dislike,. True = like
    private Boolean like;

    public eventos(){

    }

    @Override
    public String toString() {
        return "eventos{" +
                "id=" + id +
                ", picture='" + picture + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", city='" + city + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", like=" + like +
                '}';
    }

    public String toStringToAdd() {
        return "eventos{" +
                "id=" + id +
                ", picture='" + picture + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", city='" + city + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", like=" + like +
                '}';
    }

    public eventos(int id, String name, String type, String city, String timestamp, int picture ,Boolean like){
        this.id = id;
        this.name = name;
        this.type = type;
        this.city = city;
        this.timestamp = timestamp;
        this.picture = picture;
        this.like = like;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
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

    public Boolean getLike() {
        return like;
    }

    public void setLike(Boolean like) {
        this.like = like;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.picture);
        dest.writeString(this.name);
        dest.writeString(this.type);
        dest.writeString(this.city);
        dest.writeString(this.timestamp);
        dest.writeValue(this.like);
    }

    protected eventos(Parcel in) {
        this.id = in.readInt();
        this.picture = in.readInt();
        this.name = in.readString();
        this.type = in.readString();
        this.city = in.readString();
        this.timestamp = in.readString();
        this.like = (Boolean) in.readValue(Boolean.class.getClassLoader());
    }

    public static final Creator<eventos> CREATOR = new Creator<eventos>() {
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
