package com.example.sawon.bloodarrangingsystem.utils;

/**
 * Created by sawon on 11/4/2017.
 */

public class Bloodbank {
    private int id;
    private String name;
    private String contact;
    private String service_time;
    private String address;

    public Bloodbank(int id, String name, String contact, String service_time, String address) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.service_time = service_time;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getService_time() {
        return service_time;
    }

    public String getAddress() {
        return address;
    }
}
