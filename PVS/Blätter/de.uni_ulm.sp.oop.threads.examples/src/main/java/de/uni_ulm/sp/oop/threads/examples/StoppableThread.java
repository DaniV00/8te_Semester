package de.uni_ulm.sp.oop.threads.examples;

/** Example for a suspendable and resumable thread. */
public class StoppableThread implements Runnable {

  private static final int SLEEP_DURATION_3 = 5000;
  private static final int SLEEP_DURATION_2 = 10000;
  private static final int SLEEP_DURATION_1 = 1000;
  private Thread doTheWork;
  private boolean suspended = false;

  public void start() {
    doTheWork = new Thread(this);
    doTheWork.start();
  }

  public synchronized void stop() {
    doTheWork = null;
    notify();
  }

  /** suspends this thread. */
  public synchronized void suspend() {
    if (!suspended) {
      suspended = true;
      notify();
    }
  }

  /** resumes this thread. */
  public synchronized void resume() {
    if (suspended) {
      suspended = false;
      notify();
    }
  }

  @Override
  public void run() {
    Thread thisThread = Thread.currentThread();
    while (doTheWork == thisThread) {
      try {
        // avoids a synchronisation if it is not necessary
        if (suspended) {
          synchronized (this) {
            while (suspended) {
              wait();
            }
          }
        }

        Thread.sleep(SLEEP_DURATION_1);
      } catch (InterruptedException e) {
        // do intentionally nothing, cause the interruption was expected.
      }

      // the real work should always be done at the end of a thread, cause
      // then it is executed immediately after the thread is resumed or notified.
      System.out.println("Doing something important");
    }
    System.out.println("doing some finishing work...");
  }

  /** starts a thread t and suspend and resumes it several times. */
  public static void main(String[] args) {
    StoppableThread t = new StoppableThread();
    t.start();

    try {
      Thread.sleep(SLEEP_DURATION_2);
    } catch (InterruptedException e) {
      // do intentionally nothing, cause the interruption was expected.
    }

    System.out.println("Suspending the Thread");
    t.suspend();
    System.out.println("Waiting for 5s");
    try {
      Thread.sleep(SLEEP_DURATION_3);
    } catch (InterruptedException e) {
      // do intentionally nothing, cause the interruption was expected.
    }
    System.out.println("resuming the Thread.");
    t.resume();
    System.out.println("Waiting for 5s");
    try {
      Thread.sleep(SLEEP_DURATION_3);
    } catch (InterruptedException e) {
      // do intentionally nothing, cause the interruption was expected.
    }


    System.out.println("Stopping the Thread");
    t.stop();

    System.out.println("Waiting for 5s");
    try {
      Thread.sleep(SLEEP_DURATION_3);
    } catch (InterruptedException e) {
      // do intentionally nothing, cause the interruption was expected.
    }
    System.out.println("main finished.");
  }

}
