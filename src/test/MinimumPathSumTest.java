package test;

import code.MinimumPathSum;

public class MinimumPathSumTest {
	public static void main(String[] args) {
		int[][] grid = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		MinimumPathSum test = new MinimumPathSum();
		System.out.print(test.minPathSum(grid));
	}
}
