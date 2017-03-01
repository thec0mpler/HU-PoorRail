package org.hu.richrail.model;

public abstract class Vehicle {
    private int seats = 0;

    public Vehicle() {
    }

    public int getSeats() {
        return this.seats;
    }

    public abstract String getName();

    public abstract void setName(String name);

    public abstract boolean equals(Object object);

    public abstract String toString();

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
