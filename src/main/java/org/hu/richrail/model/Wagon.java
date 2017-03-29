package org.hu.richrail.model;

public class Wagon {
    private String name;
    private int seats = 20;
    private Train train;

    public Wagon(String name, int seats) throws Exception {
        setName(name);
        setSeats(seats);
    }

    public Wagon(String name) throws Exception {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name == null || name.isEmpty())
            throw new Exception("name is empty, not allowed!");

        this.name = name;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) throws Exception {
        if (seats < 0 && seats > 50)
            throw new Exception("The seats are not between 0 and 50");

        this.seats = seats;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wagon wagon = (Wagon) o;

        return name != null ? name.equals(wagon.name) : wagon.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }


}
