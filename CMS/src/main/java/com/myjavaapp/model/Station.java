package com.myjavaapp.model;

public class Station {
 private int id;
 private String station_title;
 private String address;
 private StationHead station_head;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStation_title() {
        return station_title;
    }

    public void setStation_title(String station_title) {
        this.station_title = station_title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public StationHead getStation_head() {
        return station_head;
    }

    public void setStation_head(StationHead station_head) {
        this.station_head = station_head;
    }
}
