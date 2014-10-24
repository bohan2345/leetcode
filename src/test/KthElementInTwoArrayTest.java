package test;

import code.KthElementInTwoArray;

public class KthElementInTwoArrayTest {
	public static void main(String[] args) {
		KthElementInTwoArray test = new KthElementInTwoArray();
		int[] A = { 2 };
		int[] B = { 1, 3, 4 };
		System.out.println(test.find(A, B, 3));
	}
}
