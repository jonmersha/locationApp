package com.hira_software.location_by_yohannes.repository;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {LocationModel.class},version = 1,exportSchema = false)
public abstract class LocationRoomDataBase extends RoomDatabase {

    public abstract LocationDao locationDao();
    public static volatile LocationRoomDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS=4;
    static final ExecutorService databaseWriteExecutor=
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    static LocationRoomDataBase getDataBase(final Context context){
        if(INSTANCE==null){
            synchronized (LocationRoomDataBase.class){
                if(INSTANCE==null){
                    INSTANCE= Room.databaseBuilder(
                            context.getApplicationContext(),
                            LocationRoomDataBase.class,
                            "location_database")
                            .addCallback(remoteCallBack)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
   public static  RoomDatabase.Callback remoteCallBack=new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
//            databaseWriteExecutor.execute(()->{
//                LocationDao locationDao=INSTANCE.locationDao();
//                LocationModel locationModel=new LocationModel();
//                locationModel.setLocationName("Asselella");
//                locationModel.setLocationDescription("City in Ethiopia");
//                locationModel.setLatitude(10);
//                locationModel.setLongitude(10);
//                locationModel.setCaptureTime("Today");
//                locationDao.insert(locationModel);
//            });

        }
    };
}
