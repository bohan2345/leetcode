package code;

public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		if (n == 0)
			return matrix;
		int a = 0, base = 0;
		for (int i = 0; i < (n + 1) / 2; i++) {
			if (i == 0)
				base = 0;
			else
				base = matrix[i][i - 1];
			for (int j = i; j < n - i - 1; j++) {
				matrix[i][j] = base + 1 + a;
				matrix[j][n - i - 1] = base + (n - 2 * i - 1) + 1 + a;
				matrix[n - i - 1][n - j - 1] = base + 2 * (n - 2 * i - 1) + 1 + a;
				matrix[n - j - 1][i] = base + 3 * (n - 2 * i - 1) + 1 + a;
				a++;
			}
			a = 0;
		}
		if (n % 2 != 0) {
			matrix[n / 2][n / 2] = n * n;
		}
		return matrix;
	}
	
	public int[][] generateMatrixII(int n) {
		if (n < 0)
			throw new IllegalArgumentException();
		if (n == 0)
			return new int[0][0];
		int[][] matrix = new int[n][n];
		int count = 1;
		int i = 0, j = 0, d = 0; // d = 0 right, 1 down, 2 left, 3 up
		while (true) {
			matrix[i][j] = count;
			if (d == 0) {
				j++;
				if (j == n - i - 1)
					d++;
			} else if (d == 1) {
				i++;
				if (i == j)
					d++;
			} else if (d == 2) {
				j--;
				if (j == n - i - 1)
					d++;
			} else if (d == 3) {
				i--;
				if (i == j + 1)
					d = 0;
			}
			if (count == n * n)
				break;
			count++;
		}
		return matrix;
	}
}
