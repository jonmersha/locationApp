package com.hira_software.location_by_yohannes;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.hira_software.location_by_yohannes.repository.LocationData;
import com.hira_software.location_by_yohannes.repository.LocationModel;

import java.util.ArrayList;
import java.util.List;

public class LocationAdaptor extends RecyclerView.Adapter <LocationAdaptor.LocationHolder>{

    private List<LocationModel> locationList=new ArrayList<>( );

    @NonNull
    @Override
    public LocationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_component,parent,false);
        return  new LocationHolder(itemView);
    }
    @NonNull
    @Override
    public void onBindViewHolder(@NonNull LocationHolder holder, int position) {
        LocationModel currentLocation=locationList.get(position);
        //internal not visible on list
        holder.locationId=currentLocation.getLocId();
        holder.latitude=currentLocation.getLatitude();
        holder.longitude=currentLocation.getLongitude();
       // displayed on list of location
        holder.locationName.setText(currentLocation.getLocationName());
        holder.locationDescription.setText(currentLocation.getLocationDescription());
        holder.captureTime.setText(currentLocation.getCaptureTime());

    }
    @Override
    public int getItemCount() {
        return locationList.size();
    }

    class LocationHolder extends RecyclerView.ViewHolder{
        private int locationId;
        private double latitude;
        private double longitude;
        private TextView locationName;
        private TextView locationDescription;
        private TextView captureTime;
        private CardView card;


        public LocationHolder(@NonNull View itemView) {
            super(itemView);

            this.locationName=itemView.findViewById(R.id.location_name);
            locationDescription=itemView.findViewById(R.id.location_description);
            captureTime=itemView.findViewById(R.id.capture_time);
            this.card=itemView.findViewById(R.id.card);

            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    LocationModel locationModel=new LocationModel();
                    locationModel.setLocId(locationId);
                    locationModel.setLatitude(latitude);
                    locationModel.setLongitude(longitude);
                    locationModel.setLocationName(locationName.getText().toString());
                    locationModel.setLocationDescription(locationDescription.getText().toString());
                    locationModel.setCaptureTime(captureTime.getText().toString());

                    LocationData.locationModel=locationModel;
                    Intent intent=new Intent(view.getContext(),EditLocation.class);
                    view.getContext().startActivity(intent);
                }
            });



        }
    }

    public void setLocationList(List<LocationModel> locationList) {
        this.locationList = locationList;
        notifyDataSetChanged();
    }
}
