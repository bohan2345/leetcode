package code;

public class SetZeroes {
	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		if (m == 0)
			throw new IllegalArgumentException();
		int n = matrix[0].length;
		if (n == 0)
			throw new IllegalArgumentException();
		boolean t = false, l = false;
		for (int i = 0; i < m; i++)
			if (matrix[i][0] == 0)
				l = true;
		for (int j = 0; j < n; j++)
			if (matrix[0][j] == 0)
				t = true;
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for (int i = 1; i < m; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 0; j < n; j++)
					matrix[i][j] = 0;
			}
		}
		for (int j = 1; j < n; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 0; i < m; i++)
					matrix[i][j] = 0;
			}
		}
		if (l) {
			for (int i = 0; i < m; i++)
				matrix[i][0] = 0;
		}
		if (t) {
			for (int j = 0; j < n; j++)
				matrix[0][j] = 0;
		}
	}
}
