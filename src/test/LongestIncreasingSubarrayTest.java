package test;

import code.LongestIncreasingSubarray;

public class LongestIncreasingSubarrayTest {
	public static void main(String[] args) {
		LongestIncreasingSubarray test = new LongestIncreasingSubarray();
		int[] A = { 1, 2, 3, 1, 2, 3 };
		int i = test.findLongest(A);
		System.out.println(i);
	}
}
