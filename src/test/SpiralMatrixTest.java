package test;

import java.util.List;

import code.SpiralMatrix;

public class SpiralMatrixTest {
	public static void main(String[] args) {
		SpiralMatrix test = new SpiralMatrix();
		// int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int[][] matrix = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
		List<Integer> x = test.spiralOrderII(matrix);
		System.out.println(x.toString());
	}
}
