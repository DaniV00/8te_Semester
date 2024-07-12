package de.uni_ulm.sp.oop.threads.bank;

/** simulator for infinite many deposits. */
public class DepositThread extends Thread {

  private static final int SLEEP_TIME = 1;
  private static final int DEPOSIT_AMOUNT = 100;

  @Override
  public void run() {
    for (;;) {
      ThreadClash.deposit(DEPOSIT_AMOUNT);
      try {
        Thread.sleep(SLEEP_TIME);
      } catch (InterruptedException e) {
        return;
      }
    }
  }

}
