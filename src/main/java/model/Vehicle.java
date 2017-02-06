package model;

public abstract class Vehicle {
    private int seats = 0;

    public Vehicle() {
    }

    public int getSeats() {
        return this.seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
