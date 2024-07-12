package de.uni_ulm.sp.oop.threads.bank20;

/** Class that represents a clerk. */
public class BankAngestellte extends Thread {

  private static final int MAX_ABZUG = 500;
  private static final int MAX_BETRAG = 1000;
  private static final int MAX_KONTONR = 100;
  private static final int BUCHUNGEN = 10000;
  private Bank bank;

  /** public simple constructor. */
  public BankAngestellte(String name, Bank bank) {
    super(name);
    this.bank = bank;
    start();
  }

  @Override
  public void run() {
    // 10.000 Buchungen durchf�hren
    for (int i = 0; i < BUCHUNGEN; i++) {
      /*
       * Kontonummer einlesen; simuliert durch Wahl einer Zufallszahl zwischen 0 und 99
       */
      int kontonr = (int) (Math.random() * MAX_KONTONR);

      /*
       * �berweisungsbetrag einlesen; simuliert durch Wahl einer Zufallszahl zwischen -500 und +499
       */
      float betrag = (int) (Math.random() * MAX_BETRAG) - MAX_ABZUG;

      bank.buchen(kontonr, betrag);
    }
  }
}
