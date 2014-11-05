package code;

public class MaxProductSubarray {
	public int maxProduct(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		int max = A[0];
		int min = A[0];
		int x = max;
		for (int i = 1; i < A.length; i++) {
			int tmp = max;
			if (A[i] > 0) {
				max = Math.max(A[i], max * A[i]);
				min = Math.min(A[i], min * A[i]);
			} else {
				max = Math.max(A[i], min * A[i]);
				min = Math.min(A[i], tmp * A[i]);
			}
			x = Math.max(x, max);
		}
		return x;
	}
}
