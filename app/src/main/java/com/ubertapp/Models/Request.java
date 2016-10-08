package com.ubertapp.Models;


public class Request {
    private final double cost;
    private final String driverId;
    private final String riderId;

    public Request(double cost, String driverId, String riderId) {
        this.cost = cost;
        this.riderId = riderId;
        this.driverId = driverId;
    }


    public double getCost() {
        return cost;
    }

    public String getDriverId() {
        return driverId;
    }

    public String getRiderId() {
        return riderId;
    }
}
