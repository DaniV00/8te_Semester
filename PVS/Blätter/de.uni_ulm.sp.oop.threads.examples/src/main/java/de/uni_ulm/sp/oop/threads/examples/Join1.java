package de.uni_ulm.sp.oop.threads.examples;

/** small demo joining a thread. */
public class Join1 implements Runnable {

  private static final int REPETITIONS1 = 200;
  private static final int REPETITIONS2 = 10;

  @Override
  public void run() {
    for (int i = 0; i < REPETITIONS1; i++) {
      System.out.println(i + ": Hello, concurrent world!");
    }
    System.out.println("t finished");
  }

  /** starts a thread t and joins it again. */
  public static void main(String[] args) {
    Runnable runner = new Join1();
    Thread t = new Thread(runner);
    t.start();

    for (int i = 0; i < REPETITIONS2; i++) {
      System.out.println(i + ": Main!");
    }

    try {
      t.join();
    } catch (InterruptedException e) {
      // do intentionally nothing, cause the interruption was expected.
    }

    System.out.println("main finished");
  }
}
