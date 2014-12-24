package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (num == null || num.length < 4)
			return res;
		Arrays.sort(num);
		int a = 0, b = a + 1, c = b + 1, d = num.length - 1;
		for (; a < num.length - 3; a++) {
			for (b = a + 1; b < num.length - 2; b++) {
				c = b + 1;
				d = num.length - 1;
				while (c < d) {
					int sum = num[a] + num[b] + num[c] + num[d];
					if (sum == target) {
						List<Integer> quad = new ArrayList<>();
						quad.add(num[a]);
						quad.add(num[b]);
						quad.add(num[c]);
						quad.add(num[d]);
						res.add(quad);
						while (c < d && num[c] == num[c + 1])
							c++;
					} else if (sum > target) {
						d--;
						c--;
					}
					c++;
				}
				while (b < num.length - 2 && num[b] == num[b + 1])
					b++;
			}
			while (a < num.length - 3 && num[a] == num[a + 1])
				a++;
		}
		return res;
	}
}
