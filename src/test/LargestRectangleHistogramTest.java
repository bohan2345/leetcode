package test;

import code.LargestRectangleHistogram;

public class LargestRectangleHistogramTest {
	public static void main(String[] args) {
		LargestRectangleHistogram test = new LargestRectangleHistogram();
		int[] A = { 4, 2, 0, 3, 2, 5 };
		int i = test.largestRectangleAreaII(A);
		int ii = test.largestRectangleArea(A);
		System.out.println(i + " : " + ii);
	}
}
