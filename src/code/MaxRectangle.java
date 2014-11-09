package code;

public class MaxRectangle {
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		int[] A = new int[matrix[0].length];
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int height = 0;
				if (matrix[i][j] == '1') {
					while (i + height < matrix.length && matrix[i + height][j] == '1')
						height++;
					A[j] = height;
				} else {
					A[j] = 0;
				}
			}
			max = Math.max(max, new LargestRectangleHistogram().largestRectangleArea(A));
		}
		return max;
	}
}
