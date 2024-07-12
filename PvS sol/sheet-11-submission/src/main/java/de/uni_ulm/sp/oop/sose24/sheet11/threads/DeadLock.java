package de.uni_ulm.sp.oop.sose24.sheet11.threads;

public class DeadLock implements Runnable {

  public static void main(String[] args) throws Exception {
    for (int i = 1; i < 100; i++) {
      System.out.println("Test: " + i);
      Object l1 = new Object();
      Object l2 = new Object();
      Thread t1 = Thread.ofPlatform().daemon().start(new DeadLock(l1, l2));
      Thread t2 = Thread.ofPlatform().daemon().start(new DeadLock(l2, l1));
      t1.join();
      t2.join();
    }
  }

  private Object lock1;
  private Object lock2;

  public DeadLock(Object lock1, Object lock2) {
    this.lock1 = lock1;
    this.lock2 = lock2;
  }

  public void run() {
    synchronized (lock1) {
      System.out.println("First lock acquired!");
      synchronized (lock2) {
        System.out.println("Second lock acquired!");
      }
    }
    System.out.println("Done! All locks released!");
  }
}