package de.hsog.queens;

public class Chessboard {

	private int[] queensPositions; // das Array fuer die Damen
	private int N; // maximaler Index in a
	private boolean[] u, d, zeilen; // Arrays fuer die Diagonalen und Zeilen

	Chessboard(int n) { // Konstruktor
		N = n - 1;
		queensPositions = new int[n];
		u = new boolean[2 * n - 1]; // aufsteigende Diagonale
		d = new boolean[2 * n - 1]; // absteigende Diagonale
		zeilen = new boolean[n]; // Zeilen
		
		for (int i = 0; i <= N; i++) {
			queensPositions[i] = -1;
			zeilen[i] = true;
		} // Zeilen & Spalten sind frei
		
		for (int i = 0; i < u.length; i++)
			u[i] = d[i] = true; // Diagonalen sind frei
	}

	boolean moveQueen(int i) { // versuche Dame in Spalte i
		int j = queensPositions[i]; // in naechste Zeile zu setzen
		if (j >= 0)
			changeConfiguration(i, j); // befreie Feld
		for (j++; j <= N; j++)
			if (isThreatened(i, j)) {
				changeConfiguration(i, j); // besetze Feld
				break;
			}
		return j <= N; // Versuch erfolgreich?
	}

	private void changeConfiguration(int i, int j) { // belege oder befreie
		u[i + j] = d[i - j + N] = zeilen[j] = queensPositions[i] == j; // Feld (i,j)
		queensPositions[i] = zeilen[j] ? -1 : j;
	}

	boolean isThreatened(int i, int j) { // ist Feld (i,j) unbedroht?
		return u[i + j] && d[i - j + N] && zeilen[j];
	}

	public String toString() { // druckbare Darstellung
		String s = "";
		for (int i = 0; i <= N; i++)
			s += queensPositions[i] + " ";
		return s;
	}
}
