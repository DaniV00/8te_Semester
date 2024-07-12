package de.uni_ulm.sp.oop.threads.bank;

/** simulator for infinite many withdrawals. */
public class WithdrawThread extends Thread {

  private static final int SLEEP_TIME = 1;
  private static final int WITHDRAW_AMOUNT = 100;

  @Override
  public void run() {
    for (;;) {
      ThreadClash.withdraw(WITHDRAW_AMOUNT);
      try {
        Thread.sleep(SLEEP_TIME);
      } catch (InterruptedException e) {
        return;
      }
    }
  }

}
