package test;

import code.MergeSort;

public class MergeSortTest {
	public static void main(String[] args) {
		MergeSort test = new MergeSort();
		int[] A = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		test.mergeSort(A);
		for (int i = 0; i < A.length; i++)
			System.out.print(A[i]);
	}
}
