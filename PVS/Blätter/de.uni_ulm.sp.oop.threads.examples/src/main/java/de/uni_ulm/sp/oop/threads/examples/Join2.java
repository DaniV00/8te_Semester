package de.uni_ulm.sp.oop.threads.examples;

/** In this example the started thread joins the main thread. */
public class Join2 implements Runnable {

  private static final int REPETITIONS1 = 20;
  private static final int REPETITIONS2 = 10;

  Thread toJoin;

  public Join2(Thread toJoin) {
    this.toJoin = toJoin;
  }

  @Override
  public void run() {
    for (int i = 0; i < REPETITIONS1; i++) {
      System.out.println(i + ": Hello, concurrent world!");
    }

    try {
      toJoin.join();
    } catch (InterruptedException e) {
      // do intentionally nothing, cause the interruption was expected.
    }

    System.out.println("t finished");
  }

  /** start a thread t and finish myself. */
  public static void main(String[] args) {
    Runnable runner = new Join2(Thread.currentThread());
    Thread t = new Thread(runner);
    t.start();

    for (int i = 0; i < REPETITIONS2; i++) {
      System.out.println(i + ": Main!");
    }

    System.out.println("main finished");
  }
}
