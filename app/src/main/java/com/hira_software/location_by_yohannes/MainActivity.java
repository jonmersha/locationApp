package com.hira_software.location_by_yohannes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProvider;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hira_software.location_by_yohannes.repository.LocationModel;
import com.hira_software.location_by_yohannes.viewmodel.LocationViewModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements LocationListener {
    public  double lang;
    public  double lat;
    private LocationManager locationManager;
    private String provider;


    EditText locationName;
    EditText locationDescription;
    Button addLocation;


    private LocationViewModel locationViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addLocation=findViewById(R.id.add_location);
        locationName=findViewById(R.id.locationName);
        locationDescription=findViewById(R.id.locationDesctiption);
        locationViewModel= new ViewModelProvider(this).get(LocationViewModel.class);




        addLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                        .format(new Date());
                if(locationName.getText().toString().equals("") || locationDescription.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Empty Name Or Description", Toast.LENGTH_SHORT).show();

                }else{
                    LocationModel locationModel=new LocationModel();
                    locationModel.setLocationName(locationName.getText().toString());
                    locationModel.setLocationDescription(locationDescription.getText().toString());
                    locationModel.setLatitude(lat);
                    locationModel.setLongitude(lang);
                    locationModel.setCaptureTime(date);
                    locationViewModel.insert(locationModel);
                    Toast.makeText(MainActivity.this, "Location Registered", Toast.LENGTH_LONG).show();
                    locationDescription.setText("");
                    locationName.setText("");
                }



            }
        });

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, false);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            String[] permission={Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION};
            ActivityCompat.requestPermissions(MainActivity.this, permission,1);
            return;
        }

        Location location = locationManager.getLastKnownLocation(provider);

        if (location != null) {
            System.out.println("Provider " + provider + " has been selected.");
            onLocationChanged(location);
        } else {
            Toast.makeText(this, "Location not enabled", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            String[] permission={Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION};
            ActivityCompat.requestPermissions(MainActivity.this, permission,1);
            return;
        }
        locationManager.requestLocationUpdates(provider, 400, 1, this);
    }
    @Override
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        this.lat = location.getLatitude();
        this.lang = location.getLongitude();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {

    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    public void locationList(View view) {
        Intent intent=new Intent(view.getContext(),LocationList.class);
        view.getContext().startActivity(intent);

    }
}