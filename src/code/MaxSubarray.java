package code;

public class MaxSubarray {
	public int maxSubArray(int[] A) {
		int max = A[0];
		int sum = A[0];
		for (int i = 1; i < A.length; i++) {
			sum = Math.max(sum + A[i], A[i]);
			max = Math.max(sum, max);
		}
		return max;
	}
}
