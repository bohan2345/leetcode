package code;

public class MaxSubarray {
	public int maxSubArray(int[] A) {
		int sum = 0, maxSum = A[0];
		for (int i = 0; i < A.length; i++) {
			sum = sum + A[i];
			if (sum > maxSum) {
				maxSum = sum;
			}
			if (sum < 0) {
				sum = 0;
			}
		}
		return maxSum;
	}
}
