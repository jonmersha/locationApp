package com.hira_software.location_by_yohannes.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class LocationRepository {
    private LocationDao locationDao;
    private LiveData<List<LocationModel>> AllLocation;

    public LocationRepository(Application application) {

        LocationRoomDataBase db=LocationRoomDataBase.getDataBase(application);
        this.locationDao =db.locationDao() ;
        this.AllLocation = this.locationDao.getAllLocation();

    }

    public void insert(LocationModel locationModel) {
        LocationRoomDataBase.databaseWriteExecutor.execute(()->{
            locationDao.insert(locationModel);
        });

    }

    public LiveData<List<LocationModel>> getAllLocation() {
        return AllLocation;
    }
}
