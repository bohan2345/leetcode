package code;

public class BestTimeStockIII {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;
		// devide the entire time into two part,
		// right[i] denote the max profit after day i, left[i] denote the max profit before day i
		int[] right = new int[prices.length];
		int[] left = new int[prices.length];
		left[0] = 0;
		right[prices.length - 1] = 0;
		int max = prices[prices.length - 1];
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			left[i] = Math.max(prices[i] - min, left[i - 1]);
			min = Math.min(prices[i], min);
			right[prices.length - i - 1] = Math.max(max - prices[prices.length - 1 - i], right[prices.length - i]);
			max = Math.max(prices[prices.length - i - 1], max);
		}
		int profit = 0;
		for (int i = 0; i < prices.length; i++) {
			profit = Math.max(left[i] + right[i], profit);
		}
		return profit;
	}
}
