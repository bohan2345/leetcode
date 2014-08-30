package test;

import code.BinarySearch;

public class BinarySearchTest {
	public static void main(String[] args) {
		int[] A = { 2, 2 };
		int s = (new BinarySearch()).binarySearch(A, 0, A.length - 1, 3);
		System.out.println(s);
	}
}
