package test;

import code.MergeSortedArray;

public class MergeSortedArraytest {
	public static void main(String[] args) {
		MergeSortedArray test = new MergeSortedArray();
		int A[] = { 2, 0, 0 };
		int[] B = { 1 };
		test.merge(A, 1, B, 1);
		System.out.println(A[1]);
	}
}
