package de.hsog.datastructure;

import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {

		// anlegen einer ArrayListe
		ArrayList<String> liste = new ArrayList<String>();

		// fuellen der Liste mit Daten
		liste.add("Offenburg");
		liste.add("Freiburg");
		liste.add("Konstanz");
		liste.add("München");
		liste.add("Frankfurt");
		liste.add("Rhein");

		// Ausgeben der Liste
		System.out.println(liste);

		// gehoert hier nicht hin!
		liste.remove("Rhein");

		// nochmal ausgeben
		System.out.println(liste);

		// an Position 2 einfügen
		liste.add(2, "Hamburg");
		System.out.println(liste);

		// testen ob enthalten:
		if (liste.contains("Rhein")) {
			System.out.println("Rhein ist vorhanden.");
		} else {
			System.out.println("Rhein ist nicht vorhanden.");
		}

		// testen ob Offenburg enthalten:
		if (liste.contains("Offenburg")) {
			System.out.println("Offenburg existiert.");
		} else {
			System.out.println("Offenburg ist nicht in der Liste.");
		}
	}
}
