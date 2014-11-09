package test;

import code.MaxRectangle;

public class MaxRectangleTest {
	public static void main(String[] args) {
		MaxRectangle test = new MaxRectangle();
		char[][] matrix = { { '1' } };
		int x = test.maximalRectangle(matrix);
		System.out.println(x);
	}
}
