package de.uni_ulm.sp.oop.threads.examples;

/** Some very important comment. */
public class ThreadV extends Thread {

  private static final int REPETITIONS = 20;

  @Override
  public void run() {
    for (int i = 0; i < REPETITIONS; i++) {
      System.out.println("v: besch�ftigt!");
    }
  }

}
