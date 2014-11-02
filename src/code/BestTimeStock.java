package code;

public class BestTimeStock {
	public int maxProfit(int[] prices) {
		if (prices.length == 0)
			return 0;
		int[] A = new int[prices.length];
		A[0] = 0;
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			A[i] = Math.max(prices[i] - min, A[i - 1]);
			min = Math.min(prices[i], min);
		}
		return A[prices.length - 1];
	}
}
