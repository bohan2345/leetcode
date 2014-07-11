package code;

public class UniquePath {
	public int uniquePaths(int m, int n) {
		// if (m == 1 || n == 1) {
		// return 1;
		// } else if (m < 1 || n < 1) {
		// return 0;
		// } else
		// return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
		int[][] sum = new int[m][n];

		for (int i = 0; i < m ; i++) {
			for (int j = 0; j < n ; j++) {
				if (i == 0 || j == 0) {
					sum[i][j] = 1;
				} else {
					sum[i][j] = sum[i - 1][j] + sum[i][j - 1];
				}
			}
		}
		return sum[m - 1][n - 1];
	}
}
