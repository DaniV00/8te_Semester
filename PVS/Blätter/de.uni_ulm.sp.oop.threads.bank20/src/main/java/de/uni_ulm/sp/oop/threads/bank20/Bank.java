package de.uni_ulm.sp.oop.threads.bank20;

public class Bank {

	private Konto[] konten;

	public Bank() {
		konten = new Konto[100];
		for (int i = 0; i < konten.length; i++) {
			konten[i] = new Konto();
		}
	}

	public synchronized void buchen(int kontonr, float betrag) {
		konten[kontonr].buchen(betrag);
		System.out.println(String.format("Konto %2d um %5.0f ver�ndert. Neuer Stand: %6.0f", kontonr, betrag,
				konten[kontonr].abfragen()));
	}

	public static void main(String[] args) {
		Bank sparkasse = new Bank();
		BankAngestellte mueller = new BankAngestellte("Andreas M�ller", sparkasse);
		BankAngestellte schmitt = new BankAngestellte("Petra Schmitt", sparkasse);
	}
}
