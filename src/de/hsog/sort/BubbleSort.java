package de.hsog.sort;

import java.util.Arrays;

public class BubbleSort {

  public static void main(String[] args) {
		int arrayToSort[] = new int[15];
		populateArray(arrayToSort);
		System.out.println("Before Sorting: ");
		printArray(arrayToSort);
		
		// sort the array
		bubbleSort(arrayToSort);
		System.out.println("\nAfter Sorting: ");
		printArray(arrayToSort);
	}

	/**
	 * This method will sort the integer array using bubble sort algorithm
	 *
	 * @param arr
	 */
	private static void bubbleSort(int a[]) {
		int n = a.length-1;
		boolean exchanged;

		do {
			exchanged = false;
			int i;
			for (i = 0; i < n; i++) {
				if (a[i] > a[i + 1]) {
					
					// swap a[i] und a[i+1]
					int temp = a[i + 1];
					a[i + 1] = a[i];
					a[i] = temp;
					
					exchanged = true;
				}
			}
		} while (exchanged);

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