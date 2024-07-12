package de.uni_ulm.sp.oop.threads.bank20;

/** data class for an account. */
public class Konto {
  private float kontostand;

  public void buchen(float betrag) {
    kontostand += betrag;
  }

  public float abfragen() {
    return kontostand;
  }
}
