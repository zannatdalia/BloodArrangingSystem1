package com.example.sawon.bloodarrangingsystem;

/**
 * Created by sawon on 11/2/2017.
 */

public class Amb {
    private int id;
    private String contact;
    private String region;
    private String service_time;

    public Amb(int id, String contact, String region, String service_time) {
        this.id = id;
        this.contact = contact;
        this.region = region;
        this.service_time = service_time;
    }

    public int getId() {
        return id;
    }

    public String getContact() {
        return contact;
    }

    public String getRegion() {
        return region;
    }

    public String getService_time() {
        return service_time;
    }
}
