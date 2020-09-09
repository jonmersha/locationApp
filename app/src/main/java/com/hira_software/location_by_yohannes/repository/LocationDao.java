package com.hira_software.location_by_yohannes.repository;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LocationDao {
    @Insert
    void insert(LocationModel locationModel);

    @Query("DELETE FROM location_table")
    void deleteAll();

    @Query("SELECT * FROM location_table")
    LiveData<List<LocationModel>> getAllLocation();
    @Delete
    void delete(LocationModel model);

    @Query("SELECT * FROM location_table WHERE location_name like '%' || :search_key || '%'")
    public LiveData<List<LocationModel>> searchByName(String search_key);


}
