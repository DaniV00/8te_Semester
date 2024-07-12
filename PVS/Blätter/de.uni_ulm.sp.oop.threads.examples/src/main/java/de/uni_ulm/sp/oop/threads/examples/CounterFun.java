package de.uni_ulm.sp.oop.threads.examples;

/** Interesting aspects, when dealing with threads. Here: strange counters. */
public class CounterFun extends Thread {

  private static final int REPETITIONS = 10000;
  private int i = 0;
  private int j = 0;

  @Override
  public void run() {
    System.out.println("D");
    for (int i = 0; i < REPETITIONS; i++) {
      incI();
      incJ();
    }
    System.out.println("C");
  }

  /** increments I. */
  public void incI() {
    i += 1;
  }

  /** increments J. */
  public void incJ() {
    j += 1;
  }

  public int getI() {
    return i;
  }

  public int getJ() {
    return j;
  }

  /** main function starts several threads and increments variables. */
  public static void main(String[] args) {
    CounterFun t = new CounterFun();
    t.start();

    System.out.println("A");

    for (int i = 0; i < REPETITIONS; i++) {
      t.incI();
      t.incJ();
    }

    try {
      t.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("B");

    System.out.println("i = " + t.getI() + "   j = " + t.getJ());
  }

}

