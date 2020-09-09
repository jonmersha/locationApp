package com.hira_software.location_by_yohannes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hira_software.location_by_yohannes.repository.LocationModel;
import com.hira_software.location_by_yohannes.viewmodel.LocationViewModel;

import java.util.List;

public class LocationList extends AppCompatActivity {

    EditText searchText;

    LocationAdaptor locationAdaptor;
    private LocationViewModel locationViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);

        searchText=findViewById(R.id.search_key);

        RecyclerView recyclerView=findViewById(R.id.location_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        locationAdaptor=new LocationAdaptor();
        recyclerView.setAdapter(locationAdaptor);

        locationViewModel= new ViewModelProvider(this).get(LocationViewModel.class);
        loadLocation("");

    }

    public void loadLocation(String location_key){


        locationViewModel.getAllLocation().observe(this, new Observer<List<LocationModel>>() {
            @Override
            public void onChanged(List<LocationModel> locationModels) {
                locationAdaptor.setLocationList(locationModels);
            }
        });
    }

    public void loadSelectedLocation(View view ){



    }

    public void resetSearch(View view) {


    }
}