package com.example.assesment;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import java.util.Objects;

public class Flight {
    public String id;
    public String locationd;
    public String tripd;
    public String locationa;
    public String tripa;
    public String dated;
    public String datea;
    public String passenger;
    public String flightclass;
    public String price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocationd() {
        return locationd;
    }

    public void setLocationd(String locationd) {
        this.locationd = locationd;
    }

    public String getTripd() {
        return tripd;
    }

    public void setTripd(String tripd) {
        this.tripd = tripd;
    }

    public String getLocationa() {
        return locationa;
    }

    public void setLocationa(String locationa) {
        this.locationa = locationa;
    }

    public String getTripa() {
        return tripa;
    }

    public void setTripa(String tripa) {
        this.tripa = tripa;
    }

    public String getDated() {
        return dated;
    }

    public void setDated(String dated) {
        this.dated = dated;
    }

    public String getDatea() {
        return datea;
    }

    public void setDatea(String datea) {
        this.datea = datea;
    }

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }

    public String getFlightclass() {
        return flightclass;
    }

    public void setFlightclass(String flightclass) {
        this.flightclass = flightclass;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id='" + id + '\'' +
                ", locationd='" + locationd + '\'' +
                ", tripd='" + tripd + '\'' +
                ", locationa='" + locationa + '\'' +
                ", tripa='" + tripa + '\'' +
                ", dated='" + dated + '\'' +
                ", datea='" + datea + '\'' +
                ", passenger='" + passenger + '\'' +
                ", flightclass='" + flightclass + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id) && Objects.equals(locationd, flight.locationd) && Objects.equals(tripd, flight.tripd) && Objects.equals(locationa, flight.locationa) && Objects.equals(tripa, flight.tripa) && Objects.equals(dated, flight.dated) && Objects.equals(datea, flight.datea) && Objects.equals(passenger, flight.passenger) && Objects.equals(flightclass, flight.flightclass) && Objects.equals(price, flight.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, locationd, tripd, locationa, tripa, dated, datea, passenger, flightclass, price);
    }

    public static DiffUtil.ItemCallback<Flight> itemCallback = new DiffUtil.ItemCallback<Flight>() {
        @Override
        public boolean areItemsTheSame(@NonNull Flight oldItem, @NonNull Flight newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Flight oldItem, @NonNull Flight newItem) {
            return oldItem.equals(newItem);
        }
    };
}
