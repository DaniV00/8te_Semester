package de.uni_ulm.sp.oop.threads.examples;

/** . */
public class Parkhaus {
  private int plaetze;

  public Parkhaus(int plaetze) {
    if (plaetze < 0) {
      plaetze = 0;
    }
    this.plaetze = plaetze;
  }

  public synchronized int getFreiePlaetze() {
    return plaetze;
  }

  public synchronized void einfahren() {
    while (plaetze == 0) { // Bedingung wird auch nach dem Wait nochmal gepr�ft! if w�re keine
                          // L�sung!
      try {
        wait();
      } catch (InterruptedException e) {
      }
    }
    plaetze--;
  }

  public synchronized void ausfahren() {
    plaetze++;
    notify();
  }

  public static void main(String[] args) {
    Parkhaus parkhaus = new Parkhaus(10);
    for (int i = 1; i <= 40; i++) {
      Auto a = new Auto(String.format("Auto %2d", i), parkhaus);
    }
  }

}
