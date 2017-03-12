package de.hsog.sort;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int arrayToSort[] = new int[15];
		populateArray(arrayToSort);
		System.out.println("Before Sorting: ");
		printArray(arrayToSort);

		// sort the array
		selectionSort(arrayToSort);
		System.out.println("\nAfter Sorting: ");
		printArray(arrayToSort);
	}

	/**
	 * This method will sort the integer array using selection sort algorithm
	 *
	 * @param arr
	 */
	private static void selectionSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int minpos = minimumPosition(arr, i);
			int temp = arr[i];
			arr[i] = arr[minpos];
			arr[minpos] = temp;
		}
	}

	// findet die Position der kleinsten Zahl ab Position from
	private static int minimumPosition(int[] a, int from) {
		int minpos = from;
		for (int i = from + 1; i < a.length; i++)
			if (a[i] < a[minpos])
				minpos = i;
		return minpos;
	}

	public static void printArray(int[] B) {
		System.out.println(Arrays.toString(B));
	}

	public static void populateArray(int[] b) {
		for (int i = 0; i < b.length; i++) {
			b[i] = (int) (Math.random() * 100);
		}
	}

}
