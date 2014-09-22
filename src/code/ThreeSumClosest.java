package code;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
		if (num == null || num.length < 3) {
			return 0;
		}
		Arrays.sort(num);
		int sum = num[0] + num[1] + num[2], result = sum;
		int min = Math.abs(target - sum);
		for (int left = 0; left < num.length - 2; left++) {
			int right = num.length - 1;
			for (int mid = left + 1; mid < right; mid++) {
				sum = num[left] + num[mid] + num[right];
				if (Math.abs(target - sum) < min) {
					result = sum;
					min = Math.abs(target - sum);
				}
				if (target - sum == 0) {
					return sum;
				}
				if (sum - target > 0) {
					right--;
					mid--;
				}
			}
		}
		return result;
	}
}
