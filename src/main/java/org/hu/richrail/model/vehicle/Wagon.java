package org.hu.richrail.model.vehicle;

import org.hu.richrail.model.Vehicle;

public class Wagon extends Vehicle {
    private String name;

    public Wagon(String name) {
        this.name = name;
        this.setSeats(20);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object object) {
        if (object instanceof Wagon) {
            Wagon wagon = (Wagon) object;

            if (this.getName().equals(wagon.getName())) {
                return true;
            }
        }

        return false;
    }

    public String toString() {
        return name;
    }
}
