package de.hsog.recursion;

import java.text.DecimalFormat;

public class Fakultaet {

	static int fakultaetIterativ(int n) { // requires n > 0
		int ergebnis = 1;
		for (int i = 1; i <= n; i++)
			ergebnis *= i;
		return ergebnis;
	}

	static int fakultaetRekursiv(int n) { // requires n > 0
		if (n <= 1)
			return 1;
		else
			return n * fakultaetRekursiv(n - 1);
	}

	public static void main(String args[]) {
		DecimalFormat df = new DecimalFormat( "###,###,##0" );

		System.out.println("Iterativ: "+df.format(fakultaetIterativ(10)));
		System.out.println("Rekursiv: "+df.format(fakultaetRekursiv(10)));
	}
}
