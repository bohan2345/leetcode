package code;

public class SetZeroes {
	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		if (m == 0)
			return;
		int n = matrix[0].length;
		if (n == 0)
			return;
		boolean r = false, c = false;
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 0) {
				r = true;
				break;
			}
		}
		for (int j = 0; j < n; j++) {
			if (matrix[0][j] == 0) {
				c = true;
				break;
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < m; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 1; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int j = 1; j < n; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 1; i < m; i++) {
					matrix[i][j] = 0;
				}
			}
		}
		if (c) {
			for (int j = 0; j < n; j++) {
				matrix[0][j] = 0;
			}
		}
		if (r) {
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}
		}
	}
}
