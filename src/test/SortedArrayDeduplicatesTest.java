package test;

import code.SortedArrayDeduplicates;

public class SortedArrayDeduplicatesTest {
	public static void main(String[] args) {
		SortedArrayDeduplicates test = new SortedArrayDeduplicates();
		int[] A = { 1, 1, 2 };
		int j = test.removeDuplicates(A);
		System.out.println(j);
		for (int i = 0; i < j; i++) {
			System.out.print(A[i]);
		}
	}
}
