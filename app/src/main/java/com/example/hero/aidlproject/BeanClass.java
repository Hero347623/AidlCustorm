package com.example.hero.aidlproject;

import android.os.Parcel;
import android.os.Parcelable;

public class BeanClass implements Parcelable{
    private String name;
    private int age;

    public BeanClass(String name, int age){
        setName(name);
        setAge(age);
    }

    //Parcelable实现序列化
    protected BeanClass(Parcel in) {//in:只能从客户端流入
        name=in.readString();
        age=in.readInt();
    }

    public static final Creator<BeanClass> CREATOR = new Creator<BeanClass>() {
        @Override
        public BeanClass createFromParcel(Parcel in) {
            return new BeanClass(in);
        }

        @Override
        public BeanClass[] newArray(int size) {
            return new BeanClass[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(age);
    }

    public void readFromParcel(Parcel parcel){
        name=parcel.readString();
        age=parcel.readInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat:{ name="+name+",age="+age+"}\n";
    }
}
