package code;

public class BestTimeStock {
	public int maxProfit(int[] p) {
        if (p == null || p.length == 0)
            return 0;
        int max = 0, tmp = 0;
        for (int i = 1; i < p.length; i++) {
            tmp = Math.max(tmp + p[i] - p[i - 1], 0);
            max = Math.max(max, tmp);
        }
        return max;
    }
}