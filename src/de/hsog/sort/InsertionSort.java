package de.hsog.sort;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int arrayToSort[] = new int[15];
		populateArray(arrayToSort);
		System.out.println("Before Sorting: ");
		printArray(arrayToSort);
		
		// sort the array
		insertionSort(arrayToSort);
		System.out.println("\nAfter Sorting: ");
		printArray(arrayToSort);
	}

	/**
	 * This method will sort the integer array using insertion sort algorithm
	 *
	 * @param arr
	 */
	private static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			
			int valueToSort = arr[i];
			int j = i;
			
			while (j > 0 && arr[j-1] > valueToSort){
				arr[j] = arr[j-1];
				j--;
			}
			
			arr[j] = valueToSort;
		
		}
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
