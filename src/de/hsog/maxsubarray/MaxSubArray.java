package de.hsog.maxsubarray;

import java.io.File;

import de.hsog.helper.In;
import de.hsog.helper.StopWatch;

/**
 * File: MaxSubArray.java Programm behandelt das Maximum-Subarray-Problem, siehe
 * - J.L. Bentley: Programming Pearls, Communications of the ACM, 27, 865-871,
 * 1984
 * 
 * Das gleiche Problem wird drei mal mit Hilfe von verschiedenen Methoden
 * geloest: maxSubArrayBF, maxSubArrayDC und maxSubArrayScan Die Laufzeiten
 * koennen verglichen werden. Testdaten und Helper stammen von
 * http://www.cs.princeton.edu/~rs/
 * 
 * @author Trahasch
 */
public class MaxSubArray {
	static long count;

	public static void main(String args[]) {

		// Testdaten lesen
		In in = new In();
		if (args.length == 0) {
			System.out.println("Datei mit Daten angeben.");
			System.out.println(" Verwende 1Kints.txt");
			in = new In("data"+File.separator+"8Kints.txt");
			//System.exit(0);
		} else {
			in = new In(args[0]);
		}
		int[] x = in.readAllInts();

		System.out.println("Das Array: " + intArrayToString(x));
		System.out.println();
		
		StopWatch watch = new StopWatch();
		watch.start();

		out("maxSubArray Brute Force", x, maxSubArrayBF(x));
		watch.stop();
		System.out.println("Time in sec: " + watch.getTime());
		System.out.println();

		watch.start();
		out("maxSubArray Dive and Conquer", x, maxSubArrayDC(x));
		watch.stop();
		System.out.println("Time in sec: " + watch.getTime());
		System.out.println();

		watch.start();
		out("maxSubArray Scanline", x, maxSubArrayScan(x));
		watch.stop();
		System.out.println("Time in sec: " + watch.getTime());
	}

	// Methode Brute Force
	// schnell geschrieben, laeuft aber langsam
	public static Integer3 maxSubArrayBF(int[] a) {
		count = 0;
		Integer3 result = new Integer3();

		// u = upper index
		// l = lower index of array
		for (int l = 0; l < a.length; l++)
			for (int u = l; u < a.length; u++) {
				long summe = 0;
				for (int i = l; i <= u; i++) {
					summe += a[i];
					count++;
				}
				if (result.sum < summe)
					result.set(l, u, summe);
			}
		return result;
	}

	// Divide and Conquer, rekursive Loesung
	public static Integer3 maxSubArrayDC(int[] a) {
		count = 0;
		
		if (a.length == 0){
			return new Integer3();
		}
		
		return maxSubArrayDC(a, 0, a.length - 1);
	}

	/*
	 * a = Array
	 * l = lower index
	 * u = upper index of array
	 */
	public static Integer3 maxSubArrayDC(int[] a, int l, int u) {
		if (l == u) {
			count++;
			if (a[u] <= 0)
				return new Integer3(u + 1, l - 1, 0);
			else
				return new Integer3(l, u, a[u]);
		}
		
		// rekursiver Aufruf
		int m = (l + u) / 2;
		Integer3 A = maxSubArrayDC(a, l, m);
		Integer3 B = maxSubArrayDC(a, m + 1, u);
		
		// max. Summe am rechten und linken Rand 
		Integer3 C = merge(rmax(a, l, m), lmax(a, m + 1, u));
		
		if (A.sum >= B.sum) {
			if (A.sum >= C.sum)
				return A;
			else
				return C;
		} else if (C.sum >= B.sum)
			return C;
		else
			return B;
	}

	// berechnet maximale Summe am linken Rand
	public static Integer3 lmax(int[] a, int l, int u) {
		Integer3 ergebnis = new Integer3(l, l - 1, 0);
		long summe = 0;
		for (int i = l; i <= u; i++) {
			count++;
			summe = summe + a[i];
			if (summe > ergebnis.sum)
				ergebnis.set(l, i, summe);
		}
		return ergebnis;
	}

	// berechnet maximale Summe am rechten Rand
	public static Integer3 rmax(int[] a, int l, int u) {
		Integer3 ergebnis = new Integer3(u + 1, u, 0);
		long summe = 0;
		for (int i = u; i >= l; i--) {
			count++;
			summe += a[i];
			if (summe > ergebnis.sum)
				ergebnis.set(i, u, summe);
		}
		return ergebnis;
	}

	public static Integer3 merge(Integer3 l, Integer3 r) {
		return new Integer3(l.lower, r.upper, l.sum + r.sum);
	}

	// Das Scan-Line Verfahren, einmal durch, daher schnell
	public static Integer3 maxSubArrayScan(int[] a) {
		count = 0;
		Integer3 bisMax = new Integer3();
		Integer3 scanMax = new Integer3();
		
		for (int i = 0; i < a.length; i++) {
			count++;
			scanMax.upper = i;
			scanMax.sum += a[i];
			if (scanMax.sum <= 0)
				scanMax.set(i + 1, i, 0);
			else if (scanMax.sum > bisMax.sum)
				bisMax.set(scanMax);
		}
		return bisMax;
	} // maxSubArrayScan

	public static String intArrayToString(int[] a) {
		return intArrayToString(a, 0, a.length - 1);
	}

	public static String intArrayToString(int[] a, int l, int u) {
		StringBuffer sb = new StringBuffer("[");
		if (u < l)
			sb.append("]");
		else {
			for (int i = l; i < u; i++)
				sb.append(a[i]).append(", ");
			sb.append(a[u]).append("]");
		}
		return sb.toString();
	}

	public static void out(String verfahren, int[] a, Integer3 ergebnis) {
		System.out.println(verfahren + ":\n  " + ergebnis + ", "
				+ intArrayToString(a, ergebnis.lower, ergebnis.upper)
				+ "\n  count = " + count);
	}
}