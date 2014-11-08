package code;

public class TrappingRainWater {
	public int trap(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		int[] leftMax = new int[A.length];
		leftMax[0] = 0;
		for (int i = 1; i < A.length; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], A[i - 1]);
		}
		int[] rightMax = new int[A.length];
		rightMax[A.length - 1] = 0;
		for (int i = A.length - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], A[i + 1]);
		}
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += Math.max(Math.min(leftMax[i], rightMax[i]) - A[i], 0);
		}
		return sum;
	}
}