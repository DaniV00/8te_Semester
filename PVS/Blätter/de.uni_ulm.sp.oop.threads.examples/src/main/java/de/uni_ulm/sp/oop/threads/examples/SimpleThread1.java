package de.uni_ulm.sp.oop.threads.examples;

/** very simple thread as first example. */
public class SimpleThread1 extends Thread {

  private static final int REPETITIONS1 = 20;
  private static final int REPETITIONS2 = 20;

  @Override
  public void run() {
    for (int i = 0; i < REPETITIONS1; i++) {
      System.out.println("Hello, concurrent world!");
    }
    System.out.println("t finished");
  }

  /** starts thread t and does some things. */
  public static void main(String[] args) {
    Thread t = new SimpleThread1();
    t.start();

    for (int i = 0; i < REPETITIONS2; i++) {
      System.out.println("Main!");
    }
    System.out.println("main finished");
  }
}
