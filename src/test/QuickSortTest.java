package test;

import code.QuickSort;

public class QuickSortTest {
	public static void main(String[] args) {
//		int[] A = { 1, 1, 2, 1, 1, 1, 5, 5 };
		int[] A = { 1, 2, 3, 9, 7, 4, 5, 6 };
		QuickSort test = new QuickSort();
		test.quickSort(A);
		for (int i = 0; i < A.length; i++)
			System.out.print(A[i]);
	}
}
