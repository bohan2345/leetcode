package code;

public class BestTimeStockN {
	public int maxProfit(int[] prices, int k) {
		int n = prices.length;
		int[][] A = new int[n][k];
		//base case (n == 0), k transaction in 0 day.
		for (int i = 0; i < k; i++) {
			A[0][i] = 0;
		}
		//base case (k == 1), max profit with 1 transaction.
		int min = prices[0];
		for (int i = 1; i < n; i++) {
			A[i][0] = Math.max(prices[i] - min, A[i - 1][0]);
			min = Math.min(prices[i], min);
		}
		for (int i = 1; i < k; i++) {
			for (int j = 1; j < n; j++) {
				// A[j][i] = Max(A[j - x][i - 1] + A[x][1]);
				int max = A[0][0];
				for (int x = 0; x <= j; x++) {
					max = Math.max(A[j - x][i - 1] + A[x][0], max);
				}
				A[j][i] = max;
			}
		}
		return A[n - 1][k - 1];
	}
}
