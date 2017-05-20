package com.fiskra.coding.challange;

public class Question1 {

	public static void main(String[] args) {
		final int[] input = new int[] { 1, 3, 4, 6, 8, 4, 2, 1, 5, 1 };
		int[] sorted = bubbleSort(input);
		for (int i = 0; i < sorted.length; i++) {
			System.out.print(sorted[i] + " ");
		}
	}

	public static int[] bubbleSort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
	/**
	 * This method shows improved bubble sort. No need to swap numbers with temp variable.
	 * @param arr
	 * @return
	 */
	
	public static int[] bubbleSortEnhanced(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					arr[i] = arr[i] + arr[j];
					arr[j] = arr[i] - arr[j];
					arr[i] = arr[i] - arr[j];
				}
			}
		}
		return arr;
	}
	

}
