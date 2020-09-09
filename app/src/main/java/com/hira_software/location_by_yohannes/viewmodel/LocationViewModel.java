package com.hira_software.location_by_yohannes.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.hira_software.location_by_yohannes.repository.LocationModel;
import com.hira_software.location_by_yohannes.repository.LocationRepository;

import java.util.List;

public class LocationViewModel extends AndroidViewModel {

    private LocationRepository locationRepository;
    private LiveData<List<LocationModel>> allLocation;

    
    public LocationViewModel(@NonNull Application application) {
        super(application);
        locationRepository=new LocationRepository(application);
        allLocation=locationRepository.getAllLocation();
    }
    public LiveData<List<LocationModel>> getAllLocation() {
        return allLocation;
    }
    public void insert(LocationModel locationModel){
        locationRepository.insert(locationModel);
    }
}
