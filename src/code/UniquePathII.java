package code;

public class UniquePathII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] A = new int[m][n];
		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 1)
				break;
			A[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			if (obstacleGrid[0][i] == 1)
				break;
			A[0][i] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1)
					continue;
				A[i][j] = A[i - 1][j] + A[i][j - 1];
			}
		}
		return A[m - 1][n - 1];
	}
}
