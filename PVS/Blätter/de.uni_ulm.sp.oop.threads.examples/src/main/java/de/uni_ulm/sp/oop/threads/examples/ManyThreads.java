package de.uni_ulm.sp.oop.threads.examples;

/** More complex example with t,u,v,w,x,y,z threads. See lecture slides. */
public class ManyThreads implements Runnable {

  private static final int DELAY_4 = 4;
  private static final int DELAY_5 = 5;
  private static final int DELAY_7 = 7;
  private static final int DELAY_3 = 3;
  private static final int REPETITIONS1 = 20;
  private static final int REPETITIONS2 = 1000;

  String name;

  public ManyThreads(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    for (int i = 0; i < REPETITIONS1; i++) {
      System.out.println(name + " is doing something very helpful!");
      if (name.equals("w")) {
        if (i == DELAY_3) {
          new Thread(new ManyThreads("x")).start();
          System.out.println("w started x");
        } else if (i == DELAY_7) {
          new Thread(new ManyThreads("y")).start();
          System.out.println("w started y");
        }
      } else {
        if (name.equals("t") && i == DELAY_5) {
          new Thread(new ManyThreads("u")).start();
          System.out.println("t started u");
        } else {
          if (name.equals("u") && i == DELAY_4) {
            new Thread(new ManyThreads("v")).start();
            System.out.println("u started v");
          }
        }
      }
    }
    System.out.println(name + " finished");
  }

  /** Main starts threads t, w, and z and runs infinitely. */
  public static void main(String[] args) {
    ManyThreads runner = new ManyThreads("t");
    Thread t = new Thread(runner);
    t.start();
    System.out.println("main started t");

    System.out.println("Main!");
    System.out.println("Main!");
    System.out.println("Main!");
    System.out.println("Main!");
    System.out.println("Main!");

    t = new Thread(new ManyThreads("w"));
    t.start();
    System.out.println("main started w");

    System.out.println("Main!");
    System.out.println("Main!");
    System.out.println("Main!");
    System.out.println("Main!");
    System.out.println("Main!");
    t = new Thread(new ManyThreads("z"));
    System.out.println("main started z");
    t.start();

    // should be infinitely often, but for presentation, it is better to
    // only have 1000 repetitions
    for (int i = 0; i < REPETITIONS2; i++) {
      System.out.println("Main!");
    }
  }
}
