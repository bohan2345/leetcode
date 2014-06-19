package code;

public class BestTimeStock {
	public int maxProfit(int[] prices) {
		int profit = 0, maxProfit = 0, temp = 0;
		for (int buy = 0; buy < prices.length; buy++) {
			for (int sell = buy; sell < prices.length; sell++) {
				temp = prices[sell] - prices[buy];
				if (temp > profit) {
					profit = temp;
				}
			}
			if (profit > maxProfit) {
				maxProfit = profit;
			}
		}
		return maxProfit;
	}
}
