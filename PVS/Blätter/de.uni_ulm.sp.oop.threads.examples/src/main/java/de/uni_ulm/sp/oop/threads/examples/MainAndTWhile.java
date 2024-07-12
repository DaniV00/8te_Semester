package de.uni_ulm.sp.oop.threads.examples;

/** Just two threads that run infinitely. */
public class MainAndTWhile implements Runnable {

  @Override
  public void run() {
    for (;;) {
      System.out.println("Hello, concurrent world!");
    }
  }

  /** starts another thread and runs infinitely. */
  public static void main(String[] args) {
    Runnable runner = new MainAndTWhile();
    Thread t = new Thread(runner);
    t.start();

    while(true) {
      System.out.println("Main!");
    }
  }
}
