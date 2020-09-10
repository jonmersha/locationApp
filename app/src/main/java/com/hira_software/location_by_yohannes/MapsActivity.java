package com.hira_software.location_by_yohannes;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hira_software.location_by_yohannes.repository.LocationData;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        this.googleMap.setMinZoomPreference(17.0f);
        this.googleMap.setMaxZoomPreference(22.0f);
        LatLng sydney = new LatLng(LocationData.locationModel.getLatitude(), LocationData.locationModel.getLongitude());
        this.googleMap.addMarker(new MarkerOptions().position(sydney).title(LocationData.locationModel.getLocationName()));
        this.googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}