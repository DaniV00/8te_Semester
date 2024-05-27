package oop.exercise2;

import java.util.Objects;

public class Station {
    private final String name;
    private Station nextStation;
    private final int fuelRequired;

    private int spiceAmount;

    public Station(String name, int fuelRequired, int spiceAmount, Station nextStation) {
        this.name = name;
        this.nextStation = nextStation;
        this.fuelRequired = fuelRequired;
        this.spiceAmount = spiceAmount;
    }

    public String getName() {
        return name;
    }

    public Station getNextStation() {
        return nextStation;
    }

    public int getFuelRequired() {
        return fuelRequired;
    }

    public int getSpice() {
        return spiceAmount;
    }

    public void setSpice(int spice) {
        this.spiceAmount = spice;
    }

    public void setNextStation(Station nextStation) {
        this.nextStation = nextStation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return fuelRequired == station.fuelRequired && spiceAmount == station.spiceAmount && Objects.equals(name, station.name) && Objects.equals(nextStation, station.nextStation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nextStation, fuelRequired, spiceAmount);
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                ", spiceAmount=" + spiceAmount +
                '}';
    }
}
