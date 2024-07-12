package de.uni_ulm.sp.oop.threads.examples;

/** Demonstration for interrupting threads. */
public class Interrupt1 implements Runnable {

  private static final int REPETITIONS1 = 20;
  private static final int REPETITIONS2 = 10;

  @Override
  public void run() {
    for (int i = 0; i < REPETITIONS1; i++) {
      if (Thread.interrupted()) {
        System.out.println("Interrupted at " + i);
        return;
      }
      System.out.println(i + ": Hello, concurrent world!");
    }
    System.out.println("t finished");
  }

  /** Starts a thread t and tries to interrupt it again. */
  public static void main(String[] args) {
    Runnable runner = new Interrupt1();
    Thread t = new Thread(runner);
    t.start();

    for (int i = 0; i < REPETITIONS2; i++) {
      System.out.println(i + ": Main!");
    }

    t.interrupt();

    System.out.println("main finished");
  }
}
