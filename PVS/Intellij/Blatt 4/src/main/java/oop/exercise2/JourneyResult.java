package oop.exercise2;
import oop.util.Exercise;

import java.util.Arrays;
import java.util.List;

public class JourneyResult {
    private final int stationsVisited;
    private final List<SpiceTransportCertificate> remainingCargo;
    private final int spiceInTrain;
    private final int fuelInTrain;
    private final Station[] stations;

    public JourneyResult(int stationsVisited, List<SpiceTransportCertificate> remainingCargo, int spiceInTrain, int fuelInTrain, Station station) {
        this.stationsVisited = stationsVisited;
        this.remainingCargo = remainingCargo;
        this.spiceInTrain = spiceInTrain;
        this.fuelInTrain = fuelInTrain;
        this.stations = unroll(station);
    }

    private static Station[] unroll(Station station) {
        int count = 1;
        final Station first = station;
        Station current = station;
        while (!first.equals(current.getNextStation())) {
            count++;
            current = current.getNextStation();
        }

        Station[] stations = new Station[count];
        current = station;
        for (int i = 0; i < count; i++) {
            stations[i] = current;
            current = current.getNextStation();
        }

        return stations;
    }

    @Exercise(task = 3, subTask = '1')
    public int stationsVisited() {
        return stationsVisited;
    }

    @Exercise(task = 3, subTask = '2')
    public List<SpiceTransportCertificate> remainingCargo() {
        return remainingCargo;
    }

    @Exercise(task = 3, subTask = '3')
    public int spiceInTrain() {
        return spiceInTrain;
    }

    @Exercise(task = 3, subTask = '4')
    public int fuelInTrain() {
        return fuelInTrain;
    }

    @Exercise(task = 3, subTask = '5')
    public int spiceOfStation(String stationName) {
        for(Station station : stations) {
            if(station.getName().equals(stationName)) {
                return station.getSpice();
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "JourneyResult{" + "\n" +
                "stationsVisited=" + stationsVisited + "\n" +
                ", remainingCargo=" + remainingCargo + "\n" +
                ", spiceInTrain=" + spiceInTrain + "\n" +
                ", fuelInTrain=" + fuelInTrain + "\n" +
                ", stations=" + Arrays.toString(stations) + "\n" +
                '}';
    }
}
