package com.hira_software.location_by_yohannes.repository;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "location_table")
public class LocationModel {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="location_id")
    private int locId;
    @ColumnInfo(name="location_name")
    @NonNull
    private String LocationName;
    @ColumnInfo(name="location_description")
    private String locationDescription;

    @ColumnInfo(name="location_lat_point")
    private double latitude;
    @ColumnInfo(name="location_lang_point")
    private double longitude;

    @ColumnInfo(name="location_capture_time")
    private String captureTime;

//    public LocationModel(String locationName, String locationDescription, long latitude, long longitude, String captureTime) {
//        LocationName = locationName;
//        this.locationDescription = locationDescription;
//        this.latitude = latitude;
//        this.longitude = longitude;
//        this.captureTime = captureTime;
//    }

    public int getLocId() {
        return locId;
    }

    public void setLocId(int locId) {
        this.locId = locId;
    }

    public String getLocationName() {
        return LocationName;
    }

    public void setLocationName(String locationName) {
        LocationName = locationName;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getCaptureTime() {
        return captureTime;
    }

    public void setCaptureTime(String captureTime) {
        this.captureTime = captureTime;
    }
}
