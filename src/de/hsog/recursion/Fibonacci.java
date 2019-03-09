package de.hsog.recursion;

import java.text.DecimalFormat;

public class Fibonacci {
	static int fibonacciRekursiv(int n) {
		if (n <= 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fibonacciRekursiv(n - 1) + fibonacciRekursiv(n - 2);
	}

	public static void main(String args[]) {
		DecimalFormat df = new DecimalFormat("###,###,##0");
		
		// Einfache Zeitmessung
		final long timeStart = System.currentTimeMillis(); 
		
		System.out.println("Rekursiv: " + df.format(fibonacciRekursiv(45)));
		
		final long timeEnd = System.currentTimeMillis();
        System.out.println("Benötigte Zeit: " + df.format((timeEnd - timeStart)) + " Millisek."); 
	}
}
