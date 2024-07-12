package de.uni_ulm.sp.oop.threads.examples;

public class Auto extends Thread {
  private Parkhaus parkhaus;

  public Auto(String name, Parkhaus parkhaus) {
    super(name);
    this.parkhaus = parkhaus;
    start();
  }

  @Override
  public void run() {
    while (true) { // 0 � 10 Sekunden warten
      try {
        sleep((int) (Math.random() * 10000));
      } catch (InterruptedException e) {
      }
      parkhaus.einfahren();
      System.out.println(getName() + ": eingefahren, freie Plaetze: " + parkhaus.getFreiePlaetze());
      try { // 0 � 20 Sekunden parken
        sleep((int) (Math.random() * 20000));
      } catch (InterruptedException e) {
      }
      parkhaus.ausfahren();
      System.out.println(getName() + ": ausgefahren, freie Plaetze: " + parkhaus.getFreiePlaetze());
    }
  }
}
