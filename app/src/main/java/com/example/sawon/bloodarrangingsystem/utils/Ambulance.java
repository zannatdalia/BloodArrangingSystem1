package com.example.sawon.bloodarrangingsystem.utils;

/**
 * Created by sawon on 10/25/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

public class Ambulance implements Parcelable {
    private int id;
    private int contact;
    private String region;
    private String service_time;
    public Ambulance(int id, int contact, String region, String service_time) {
        this.id = id;
        this.contact = contact;
        this.region = region;
        this.service_time = service_time;
    }


    protected Ambulance(Parcel in) {
        id = in.readInt();
        contact = in.readInt();
        region = in.readString();
        service_time = in.readString();
    }

    public static final Creator<Ambulance> CREATOR = new Creator<Ambulance>() {
        @Override
        public Ambulance createFromParcel(Parcel in) {
            return new Ambulance(in);
        }

        @Override
        public Ambulance[] newArray(int size) {
            return new Ambulance[size];
        }
    };

    public int getId() {
        return id;
    }

    public int getContact() {
        return contact;
    }

    public String getRegion() {
        return region;
    }

    public String getService_time() {
        return service_time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setService_time(String service_time) {
        this.service_time = service_time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(contact);
        parcel.writeString(region);
        parcel.writeString(service_time);
    }
}
