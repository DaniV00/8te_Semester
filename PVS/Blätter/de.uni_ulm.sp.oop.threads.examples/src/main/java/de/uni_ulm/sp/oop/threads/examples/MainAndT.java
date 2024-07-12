package de.uni_ulm.sp.oop.threads.examples;

/** Just two threads that act independent from each other. */
public class MainAndT implements Runnable {

  private static final int REPETITIONS1 = 20;
  private static final int REPETITIONS2 = 20;

  @Override
  public void run() {
    for (int i = 0; i < REPETITIONS1; i++) {
      System.out.println("Hello, concurrent world!");
    }
    System.out.println("t finished");
  }

  /** Starts another thread and does something. */
  public static void main(String[] args) {
    MainAndT runner = new MainAndT();
    Thread t = new Thread(runner);
    t.start();

    for (int i = 0; i < REPETITIONS2; i++) {
      System.out.println("Main!");
    }
    System.out.println("main finished");
  }
}

