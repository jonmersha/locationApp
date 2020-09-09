package com.hira_software.location_by_yohannes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hira_software.location_by_yohannes.repository.LocationData;
import com.hira_software.location_by_yohannes.viewmodel.LocationViewModel;

import java.util.List;

public class EditLocation extends AppCompatActivity {

    EditText locationName;
    EditText locationDescription;

    Button editLocation;
    Button showOnMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_location);
        locationName=findViewById(R.id.locationName);
        locationDescription=findViewById(R.id.locationDescription);
        locationName.setText(LocationData.locationModel.getLocationName());
        locationDescription.setText(LocationData.locationModel.getLocationDescription());

    }

    public void showOnmap(View view) {
       Intent intent=new Intent(view.getContext(),Map.class);
        view.getContext().startActivity(intent);
    }
}