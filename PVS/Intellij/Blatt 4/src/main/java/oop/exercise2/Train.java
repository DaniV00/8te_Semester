package oop.exercise2;

import java.util.List;

public class Train {
    private final int maxCapacity;
    private final List<SpiceTransportCertificate> cargoList;

    private int fuel;

    private int currentSpice;

    public Train(int maxCapacity, List<SpiceTransportCertificate> cargoList, int spice, int fuel) {
        this.maxCapacity = maxCapacity;
        this.cargoList = cargoList;
        this.currentSpice = spice;
        this.fuel = fuel;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public List<SpiceTransportCertificate> getCargoList() {
        return cargoList;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getCurrentSpice() {
        return currentSpice;
    }

    public void setCurrentSpice(int currentSpice) {
        this.currentSpice = currentSpice;
    }
}
