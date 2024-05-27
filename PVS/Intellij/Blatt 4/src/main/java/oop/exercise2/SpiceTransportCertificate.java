package oop.exercise2;

import java.util.Objects;

public class SpiceTransportCertificate {
    private int amount;
    private final String stationName;

    public SpiceTransportCertificate(int amount, String stationName) {
        this.amount = amount;
        this.stationName = stationName;
    }

    public String getStationName() {
        return stationName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpiceTransportCertificate that = (SpiceTransportCertificate) o;
        return amount == that.amount && Objects.equals(stationName, that.stationName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, stationName);
    }

    @Override
    public String toString() {
        return "CargoCertificate{" +
                "amount=" + amount +
                ", stationName='" + stationName + '\'' +
                '}';
    }
}
