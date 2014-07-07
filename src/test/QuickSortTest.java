package test;

import code.QuickSort;

public class QuickSortTest {
	public static void main(String[] args) {
		int[] A = { 4,1,2,3,5,6 };
		QuickSort test = new QuickSort();
		test.quickSort(A);
		for (int i = 0; i < A.length; i++)
			System.out.print(A[i]);
	}
}
