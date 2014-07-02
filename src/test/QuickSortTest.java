package test;

import code.QuickSort;

public class QuickSortTest {
	public static void main(String[] args) {
		int[] A = { 9, 8, 7, 9, 5, 4, 3, 7, 8, 2, 1 };
		QuickSort test = new QuickSort();
		test.quickSort(A);
		for (int i = 0; i < A.length; i++)
			System.out.print(A[i]);
	}
}
