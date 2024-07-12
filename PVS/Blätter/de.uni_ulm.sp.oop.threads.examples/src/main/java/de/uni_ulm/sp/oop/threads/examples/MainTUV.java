package de.uni_ulm.sp.oop.threads.examples;

/** Threads starting threads. See lecture slides. */
public class MainTUV implements Runnable {

  private static final int DELAY = 5;
  private static final int REPETITIONS1 = 20;
  private static final int REPETITIONS2 = 1000;

  String name;

  public MainTUV(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    for (int i = 0; i < REPETITIONS1; i++) {
      System.out.println(name + " is doing something very helpful!");
      if (i == DELAY && !name.equals("v")) {
        char newname = (char) (((this.name.toCharArray())[0]) + 1);
        MainTUV runner = new MainTUV(newname + "");
        Thread t = new Thread(runner);
        t.start();
      }
    }
    System.out.println(name + " finished");
  }

  /** starts thread t and prints out several times "Main!". */
  public static void main(String[] args) {
    MainTUV runner = new MainTUV("t");
    Thread t = new Thread(runner);
    t.start();

    // should be infinitely often, but for presentation, it is better to only have 1000 repetitions
    for (int i = 0; i < REPETITIONS2; i++) {
      System.out.println("Main!");
    }
  }
}

