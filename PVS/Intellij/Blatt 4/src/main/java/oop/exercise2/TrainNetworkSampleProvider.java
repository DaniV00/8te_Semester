package oop.exercise2;

import oop.util.Exercise;

import java.util.ArrayList;
import java.util.List;

public class TrainNetworkSampleProvider {

    @Exercise(task = 3, subTask = 'a')
    public static TrainNetwork getTrainNetworkSmall() {
        Station last;
        var station = new Station("Stuttgart", 10, 50,
                new Station("Ulm", 15, 25,
                        last = new Station("München", 30, 10, null)
                )
        );
        last.setNextStation(station);
        return new TrainNetwork(
                station.getNextStation(),
                new Train(10, new ArrayList<>(List.of(
                        new SpiceTransportCertificate(-25, "Ulm"),
                        new SpiceTransportCertificate(20, "Stuttgart"),
                        new SpiceTransportCertificate(5, "München")
                )), 5, 90)
        );
    }

    @Exercise(task = 3, subTask = 'b')
    public static TrainNetwork getTrainNetworkLarge() {
        Station last;
        var station = new Station("Hamburg", 30, 75,
                new Station("Frankfurt", 25, 50,
                        new Station("Köln", 15, 25,
                                new Station("Düsseldorf", 35, 0,
                                        new Station("Dresden", 40, 0,
                                                last = new Station("Berlin", 20, 100, null)
                                        )
                                )
                        )
                )
        );
        last.setNextStation(station);
        return new TrainNetwork(
                last,
                new Train(20, new ArrayList<>(List.of(
                        new SpiceTransportCertificate(-50, "Berlin"),
                        new SpiceTransportCertificate(25, "Hamburg"),
                        new SpiceTransportCertificate(-10, "Frankfurt"),
                        new SpiceTransportCertificate(5, "Köln"),
                        new SpiceTransportCertificate(-10, "Düsseldorf"),
                        new SpiceTransportCertificate(10, "Dresden")
                )), 10, 200)
        );
    }

    @Exercise(task = 3, subTask = 'c')
    public static TrainNetwork getTrainNetworkComplex() {
        Station last;
        var station = new Station("Graz", 20, 40,
                new Station("Linz", 25, 30,
                        new Station("Salzburg", 30, 20,
                                new Station("Innsbruck", 35, 10,
                                        last = new Station("Wien", 15, 60, null)
                                )
                        )
                )
        );
        last.setNextStation(station);
        return new TrainNetwork(
                last,
                new Train(15, new ArrayList<>(List.of(
                        new SpiceTransportCertificate(10, "Wien"),
                        new SpiceTransportCertificate(-5, "Graz"),
                        new SpiceTransportCertificate(5, "Linz"),
                        new SpiceTransportCertificate(5, "Salzburg"),
                        new SpiceTransportCertificate(-5, "Innsbruck"),
                        new SpiceTransportCertificate(5, "Innsbruck"),
                        new SpiceTransportCertificate(-20, "Wien"),
                        new SpiceTransportCertificate(10, "Graz"),
                        new SpiceTransportCertificate(-15, "Linz"),
                        new SpiceTransportCertificate(-10, "Salzburg"),
                        new SpiceTransportCertificate(5, "Innsbruck")
                )), 8, 150)
        );
    }

}
