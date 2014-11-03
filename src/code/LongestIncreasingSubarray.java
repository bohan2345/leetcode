package code;

public class LongestIncreasingSubarray {
	public int findLongest(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		int[][] B = new int[A.length + 1][A.length + 1];
		for (int i = 0; i <= A.length; i++) {
			B[i][i] = 1;
			B[0][i] = 0;
		}
		int max = 0;
		for (int i = 1; i < A.length; i++) {
			for (int j = i; j < A.length; j++) {
				if (A[j] > A[j - 1]) {
					B[i][j + 1] = B[i][j] + 1;
					max = Math.max(B[i][j + 1], max);
				}
			}
		}
		return max;
	}
}
