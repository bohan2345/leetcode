package code;

public class BestTimeStockN {
	public int maxProfit(int[] prices, int k) {
		int n = prices.length;
		int[][] A = new int[n + 1][k + 1];
		//base case (n == 0), k transaction in 0 day.
		//base case (k == 0), max profit with 0 transaction. 
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= n; j++) {
				// A[j][i] = Max(A[j - x][i - 1] + prices[j] - prices[j - x]);
				for (int x = 1; x <= j; x++) {
					A[j][i] = Math.max(A[j][i], Math.max(A[j - x][i - 1] + prices[j - 1] - prices[j - x], A[j - x][i]));
				}
			}
		}
		return A[n][k];
	}
}
