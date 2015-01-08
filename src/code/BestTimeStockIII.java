package code;

public class BestTimeStockIII {
	public int maxProfit(int[] p) {
		if (p == null || p.length == 0)
			return 0;
		int[] L = new int[p.length];
		int[] R = new int[p.length];
		int tmp = 0;
		for (int i = 1; i < p.length; i++) {
			tmp = Math.max(tmp + p[i] - p[i - 1], 0);
			L[i] = Math.max(L[i - 1], tmp);
		}
		tmp = 0;
		for (int i = p.length - 2; i >= 0; i--) {
			tmp = Math.max(tmp + p[i + 1] - p[i], 0);
			R[i] = Math.max(R[i + 1], tmp);
		}
		int max = 0;
		for (int i = 0; i < p.length; i++)
			max = Math.max(L[i] + R[i], max);
		return max;
	}
}
