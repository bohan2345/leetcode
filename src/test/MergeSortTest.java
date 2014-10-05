package test;

import code.MergeSort;

public class MergeSortTest {
	public static void main(String[] args) {
		MergeSort test = new MergeSort();
		int[] A = { 5, 1, 5, 5, 5, 1, 1, 1 };
		test.mergeSort(A);
		for (int i = 0; i < A.length; i++)
			System.out.print(A[i]);
	}
}
