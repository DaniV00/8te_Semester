package de.uni_ulm.sp.oop.threads.examples;

/** Example with only one thread. */
public class OnlyMain {

  private static final int REPETITIONS = 20;

  /** just do something. */
  public static void main(String[] args) {
    for (int i = 0; i < REPETITIONS; i++) {
      System.out.println("Main!");
    }
  }
}

