package code;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		int[][] A = new int[m][n];
		A[0][0] = grid[0][0];
		for (int i = 1; i < m; i++)
			A[i][0] = grid[i][0] + A[i - 1][0];
		for (int i = 1; i < n; i++)
			A[0][i] = grid[0][i] + A[0][i - 1];
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				A[i][j] = Math.min(A[i - 1][j], A[i][j - 1]) + grid[i][j];
			}
		}
		return A[m - 1][n - 1];
	}
}
