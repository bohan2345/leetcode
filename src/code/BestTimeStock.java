package code;

public class BestTimeStock {
	public int maxProfit(int[] prices) {
		if (prices.length == 0)
			return 0;
		int[] A = new int[prices.length];
		A[0] = 0;
		for (int i = 1; i < prices.length; i++) {
			A[i] = prices[i] - prices[i - 1];
		}
		int[] B = new int[A.length];
		B[0] = 0;
		int max = 0;
		for (int i = 1; i < B.length; i++) {
			if (B[i - 1] + A[i] >= 0) {
				B[i] = B[i - 1] + A[i];
				max = Math.max(max, B[i]);
			} else {
				B[i] = 0;
			}
		}
		return max;
	}
}
