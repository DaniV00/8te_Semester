package de.uni_ulm.sp.oop.threads.examples;

/** Interruption via an exception. */
public class Interrupt2 implements Runnable {

  private static final int REPETITIONS1 = 20;
  private static final int REPETITIONS2 = 10;

  @Override
  public void run() {
    try {
      for (int i = 0; i < REPETITIONS1; i++) {
        if (Thread.interrupted()) {
          throw new InterruptedException("" + i);
        }
        System.out.println(i + ": Hello, concurrent world!");
      }
      System.out.println("t finished");
    } catch (InterruptedException e) {
      System.out.println("Interrupted at " + e.getMessage());
    }
  }

  /** starts thread t and interrupts it again. */
  public static void main(String[] args) {
    Runnable runner = new Interrupt2();
    Thread t = new Thread(runner);
    t.start();

    for (int i = 0; i < REPETITIONS2; i++) {
      System.out.println(i + ": Main!");
    }

    t.interrupt();

    System.out.println("main finished");
  }
}
