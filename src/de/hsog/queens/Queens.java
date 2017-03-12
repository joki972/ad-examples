package de.hsog.queens;

public class Queens {

	static int cnt = 0; // Zaehler fuer Loesungen

	public static void main(String args[]) {
		if (args.length == 0) {
			out("Bitte einen Parameter > 0 angeben.");
		}
		
		int n = Integer.parseInt(args[0]);
		if (n <= 0) {
			out("Der Parameter sollte positiv sein!");
			return;
		}
		
		Chessboard s = new Chessboard(n);
		out("Die Lösungen des " + n + "-Damenproblems sind:");
		for (int i = 0; i >= 0;) {
			if (i == n) {
				cnt++; // Loesung! Zaehle Anzahl mit
				out("" + s); // gib Loesung aus
				i--; // zum Finden weiterer Loesungen
			}
			// Loesungen ermitteln
			if (s.moveQueen(i))
				i++; // Naechste Position in Spalte i
			else
				i--; // Backtrack !! Wenn keine Koesung in i moeglich, dann gehe eine Spalte zurueck!
		}
		out("Es gab " + cnt + " Lösungen des " + n + "-Damenproblems.");
	}

	public static void out(String st) {
		System.out.println(st);
	}
}
	/*
	 > java Dameproblem 0
	Der Parameter sollte positiv sein!
	 > java Dameproblem 1
	Die Loesungen des 1-Dameproblems sind:
	0 
	Es gab 1 Loesungen des 1-Dameproblems.
	 > java Dameproblem 2
	Die Loesungen des 2-Dameproblems sind:
	Es gab 0 Loesungen des 2-Dameproblems.
	 > java Dameproblem 3
	Die Loesungen des 3-Dameproblems sind:
	Es gab 0 Loesungen des 3-Dameproblems.
	 > java Dameproblem 4
	Die Loesungen des 4-Dameproblems sind:
	1 3 0 2 
	2 0 3 1 
	Es gab 2 Loesungen des 4-Dameproblems.
	 > java Dameproblem 5
	Die Loesungen des 5-Dameproblems sind:
	0 2 4 1 3 
	0 3 1 4 2 
	1 3 0 2 4 
	1 4 2 0 3 
	2 0 3 1 4 
	2 4 1 3 0 
	3 0 2 4 1 
	3 1 4 2 0 
	4 1 3 0 2 
	4 2 0 3 1 
	Es gab 10 Loesungen des 5-Dameproblems.
	 > java Dameproblem 6
	Die Loesungen des 6-Dameproblems sind:
	1 3 5 0 2 4 
	2 5 1 4 0 3 
	3 0 4 1 5 2 
	4 2 0 5 3 1 
	Es gab 4 Loesungen des 6-Dameproblems.
	*/

