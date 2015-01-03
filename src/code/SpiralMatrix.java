package code;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		if (matrix == null || matrix.length == 0)
			return res;
		int d = 0; // 0right, 1down, 2left, 3up
		int m = matrix.length, n = matrix[0].length;
		int i = 0, j = 0;
		if (m == 1) {
			for (int x = 0; x < n; x++)
				res.add(matrix[0][x]);
			return res;
		}
		if (n == 1) {
			for (int x = 0; x < m; x++)
				res.add(matrix[x][0]);
			return res;
		}
		while (true) {
			if (d == 0) {
				res.add(matrix[i][j]);
				j++;
				if (j == n - 1 - i)
					d = 1;
			}
			if (d == 1) {
				res.add(matrix[i][j]);
				i++;
				if (i == m - n + j)
					d = 2;
			}
			if (d == 2) {
				res.add(matrix[i][j]);
				j--;
				if (j == m - i - 1)
					d = 3;
			}
			if (d == 3) {
				res.add(matrix[i][j]);
				i--;
				if (i == j + 1)
					d = 0;
			}
			if (res.size() == m * n)
				break;
		}
		return res;
	}
}
