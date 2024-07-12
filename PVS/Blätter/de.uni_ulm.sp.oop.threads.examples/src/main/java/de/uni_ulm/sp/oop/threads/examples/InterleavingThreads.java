package de.uni_ulm.sp.oop.threads.examples;

/** simple example of interleaving threads. */
public class InterleavingThreads extends Thread {

  private static final int REPETITIONS = 15;

  @Override
  public void run() {
    System.out.println("Hello, concurrent world!");
    System.out.println("Thread finished!");
  }

  /** starts this class as a new thread and continues executing the main thread. */
  public static void main(String[] args) {
    InterleavingThreads t = new InterleavingThreads();
    t.start();

    // do something stupid
    System.out.println("right after the thread start");
    System.out.println("a little bit later");
    for (int i = 0; i < REPETITIONS; i++) {
      System.out.println("even more later");
    }

    System.out.println("Main finished");
  }

}

