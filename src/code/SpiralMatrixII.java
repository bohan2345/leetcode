package code;

public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
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
