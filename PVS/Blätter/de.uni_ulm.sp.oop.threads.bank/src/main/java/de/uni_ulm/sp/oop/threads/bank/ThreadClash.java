package de.uni_ulm.sp.oop.threads.bank;

/**
 * In der Regel ist die Ausgabe in dieser Art:
 * <p>
 * Withdrawing 100, new balance is -100 Depositing 100, new balance is 0 Withdrawing 100, new
 * balance is -100 Depositing 100, new balance is 0
 * </p>
 * <p>
 * Doch ab und zu kommt es zu seltsamer Ausgabe in etwa dieser Form:
 * </p>
 * <p>
 * Balance 0, Withdrawing 100Balance 0, Depositing 100, New Balance -100 , New Balance: 100 Balance
 * 100, Depositing 100, New Balance: 200
 * </p>
 * <p>
 * Hier wird der DepositThread mitten in seiner Ausfuehrung unterbrochen und der WithdrawThread wird
 * aktiv. Das Problematische hierbei ist, dass damit die globale Variable balance auf einen
 * inkorrekten Zustand gesetzt wird.
 * </p>
 */

public class ThreadClash {

  static int balance = 0;

  /** Just start both threads. */
  public static void main(String[] args) {
    Thread withdrawThread = new WithdrawThread();
    withdrawThread.start();

    Thread depositThread = new DepositThread();
    depositThread.start();
  }

  /** Does the deposit. */
  public static  void deposit(int amount) {
    System.out.print("Balance " + balance + ", Depositing " + amount);
    int newBalance = balance + amount;

    System.out.println(", New Balance: " + newBalance);
    balance = newBalance;
  }

  /** Does the withdrawal. */
  public static  void withdraw(int amount) {
    System.out.print("Balance " + balance + ", Withdrawing " + amount);
    int newBalance = balance - amount;

    System.out.println(", New Balance " + newBalance);
    balance = newBalance;
  }
}
