package oop.exercise2;

import oop.util.Exercise;

public class TrainNetwork {
    private final Station startStation;
    private final Train train;

    public TrainNetwork(Station startStation, Train train) {
        this.startStation = startStation;
        this.train = train;
    }

    @Exercise(task = 3, subTask = 'j')
    public JourneyResult startJourney() {
        int stationsVisited = -1;

        Station currentStation = startStation;
        while (true) {
            stationsVisited++;
            System.out.println("Now in: " + currentStation.getName() + " with " + currentStation.getSpice() + " spice and " + train.getCurrentSpice() + " trainspice and " + train.getFuel() + " fuel");

            double fuelFactor = 0.5;
            for(int i = 0; i < train.getCargoList().size(); i++) {
                SpiceTransportCertificate cargo = train.getCargoList().get(i);
                if(currentStation.getName().equals(cargo.getStationName())) {
                    train.getCargoList().remove(cargo);
                    var newStationSpice = currentStation.getSpice() - cargo.getAmount();
                    var newTrainSpice = train.getCurrentSpice() + cargo.getAmount();

                    if((newTrainSpice > train.getMaxCapacity()) && newStationSpice < 0) {
                        var biggestDiff = Math.max(train.getMaxCapacity() - train.getCurrentSpice(), -newStationSpice);
                        train.setCurrentSpice(train.getCurrentSpice() - biggestDiff);
                        currentStation.setSpice(newStationSpice + biggestDiff);
                        train.getCargoList().add(new SpiceTransportCertificate(biggestDiff, currentStation.getName()));
                    } else if(newTrainSpice < 0) {
                        train.setCurrentSpice(0);
                        currentStation.setSpice(newStationSpice + newTrainSpice);
                        train.getCargoList().add(new SpiceTransportCertificate(newTrainSpice, currentStation.getName()));
                    } else if (newTrainSpice > train.getMaxCapacity()) {
                        train.setCurrentSpice(train.getMaxCapacity());
                        currentStation.setSpice(newStationSpice + (newTrainSpice - train.getMaxCapacity()));
                        train.getCargoList().add(new SpiceTransportCertificate(newTrainSpice - train.getMaxCapacity(), currentStation.getName()));
                    } else if(newStationSpice < 0) {
                        train.setCurrentSpice(newTrainSpice + newStationSpice);
                        currentStation.setSpice(0);
                        train.getCargoList().add(new SpiceTransportCertificate(-newStationSpice, currentStation.getName()));
                    } else {
                        train.setCurrentSpice(newTrainSpice);
                        currentStation.setSpice(newStationSpice);
                    }
                    fuelFactor = 1.0;
                    break;
                }
            }


            if( (int) (currentStation.getFuelRequired() * fuelFactor) > train.getFuel()
                    || train.getCargoList().isEmpty()) {
                break;
            }
            train.setFuel(train.getFuel() - (int) (currentStation.getFuelRequired() * fuelFactor));

            System.out.println("Now leaving: " + currentStation.getName() + " with " + currentStation.getSpice() + " spice and " + train.getCurrentSpice() + " trainspice and " + train.getFuel() + " fuel");

            currentStation = currentStation.getNextStation();
        }

        return  new JourneyResult(
                stationsVisited,
                train.getCargoList(),
                train.getCurrentSpice(),
                train.getFuel(),
                currentStation
        );
    }
}
