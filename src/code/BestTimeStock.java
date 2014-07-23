package code;

public class BestTimeStock {
	public int maxProfit(int[] prices) {
		int profit = 0;
		if (prices.length == 0)
			return profit;
		int[] profits = new int[prices.length - 1];
		for (int i = 0; i < prices.length - 1; i++) {
			profits[i] = prices[i + 1] - prices[i];
		}
		int lastMaxProfit = 0;
		for (int j = 0; j < profits.length; j++) {
			profit = profit + profits[j];
			if (profit < 0) {
				profit = 0;
			}
			if (profits[j] < 0) {
			}
			if (profit > lastMaxProfit) {
				lastMaxProfit = profit;
			}
		}
		return lastMaxProfit;
	}

	public int maxProfit2(int[] prices) {
		return 0;
	}
}
