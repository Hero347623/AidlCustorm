package com.example.hero.aidlproject;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable{
    private String name;
    private int price;


    public Book(String name, int price){
        setName(name);
        setPrice(price);
    }

    //Parcelable实现序列化
    protected Book(Parcel in) {//in:只能从客户端流入
        name=in.readString();
        price=in.readInt();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(price);
    }

    public void readFromParcel(Parcel parcel){
        name=parcel.readString();
        price=parcel.readInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{ name="+name+",price="+price+"}\n";
    }
}
