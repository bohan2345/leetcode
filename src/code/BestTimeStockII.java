package code;

public class BestTimeStockII {
	public int maxProfit(int[] p) {
		if (p == null || p.length == 0)
			return 0;
		int max = 0;
		for (int i = 1; i < p.length; i++)
			max = p[i] > p[i - 1] ? max + p[i] - p[i - 1] : max;
		return max;
	}
}