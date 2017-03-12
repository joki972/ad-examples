package de.hsog.datastructure;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample {

	public static void main(String[] args) {

		// anlegen einer ArrayListe
		LinkedList<String> liste = new LinkedList<String>();

		// fuellen der Liste mit Daten
		// Elemente werden am Ende der Liste hinzugefügt!
		liste.add("Offenburg");
		liste.add("Freiburg");
		liste.add("Konstanz");
		liste.add("München");
		liste.add("Frankfurt");
		liste.add("Rhein");

		// Ausgeben der Liste
		System.out.println(liste);
		
		// mit einem Iterator
		Iterator<String> iterator = liste.listIterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());
		
		// gehoert hier nicht hin!
		liste.remove("Rhein");
		
		// addFirst
		liste.addFirst("Berlin");

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
