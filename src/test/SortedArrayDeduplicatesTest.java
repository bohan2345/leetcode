package test;

import code.SortedArrayDeduplicatesII;

public class SortedArrayDeduplicatesTest {
	public static void main(String[] args) {
		SortedArrayDeduplicatesII testII = new SortedArrayDeduplicatesII();
		int[] A = { 1, 1, 1, 2, 2, 2, 3 };
		int j = testII.removeDuplicates(A);
		System.out.println(j);
		for (int i = 0; i < j; i++) {
			System.out.print(A[i]);
		}
	}
}
