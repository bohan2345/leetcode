package test;

import code.HeapSort;

public class HeapSortTest {
	public static void main(String[] args) {
		HeapSort test = new HeapSort();
		int[] A = { 1, 4, 2, 5, 6, 2, 6, 8 };
		// int[] A = { 7, 6, 5, 4, 3, 2, 1 };
		test.heapSort(A);
		// test.shiftDown(A, 0, A.length);
		for (int i : A) {
			System.out.print(i);
		}
	}
}
