package de.hsog.recursion;

public class Hanoi {

	private static void hanoi(int n, String start, String ziel, String hilf) {
		// überträgt n Scheiben von Turm start nach Turm ziel mit Hilfe von Turm hilf
		if (n > 0) {
			hanoi(n - 1, start, hilf, ziel);
			System.out.println("Übertrage Scheibe von Turm " + start + " auf Turm " + ziel);
			hanoi(n - 1, hilf, ziel, start);
		}
	}

	public static void main(String args[]) {
		int n = 5; // default Wert
		
		// prüfe, ob String array leer ist
		if (args.length > 0) {
			try {
				n = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				n = 5;
			}
		}
		hanoi(n, "1", "3", "2");
	}
}
