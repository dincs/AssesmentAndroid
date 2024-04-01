package com.example.assesment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class FlightScheduleAdapter extends ListAdapter<Flight, FlightScheduleAdapter.FlightScheduleViewHolder> {

    FlightClickInterface flightClickInterface;
    protected FlightScheduleAdapter(@NonNull DiffUtil.ItemCallback<Flight> diffCallback, FlightClickInterface flightClickInterface) {
        super(diffCallback);
        this.flightClickInterface = flightClickInterface;
    }

    @NonNull
    @Override
    public FlightScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FlightScheduleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_flightschedule,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FlightScheduleViewHolder holder, int position) {
        Flight flight = getItem(position);
        holder.bind(flight);
    }


    class FlightScheduleViewHolder extends RecyclerView.ViewHolder{

        TextView locationd,tripd,locationa,tripa,dated,datea;
        public FlightScheduleViewHolder(@NonNull View itemView) {
            super(itemView);

            locationd = itemView.findViewById(R.id.locationd);
            tripd = itemView.findViewById(R.id.tripd);
            locationa = itemView.findViewById(R.id.locationa);
            tripa = itemView.findViewById(R.id.tripa);
            dated = itemView.findViewById(R.id.dated);
            datea = itemView.findViewById(R.id.datea);

        }

        public void bind(Flight flight){
            locationd.setText(flight.getLocationd());
            tripd.setText(flight.getTripd());
            locationa.setText(flight.locationa);
            tripa.setText(flight.tripa);
            dated.setText(flight.getDated());
            datea.setText(flight.getDatea());
        }
    }

    interface FlightClickInterface{
        public void onClick(int position);
    }


}
