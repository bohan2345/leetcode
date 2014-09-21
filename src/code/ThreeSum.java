package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> results = new ArrayList<>();
		if (num == null || num.length == 0) {
			return results;
		}
		Arrays.sort(num);
		int sum = 0;
		for (int left = 0; left < num.length - 2; left++) {
			if (left != 0 && num[left] == num[left - 1]) {
				continue;
			}
			int right = num.length - 1;
			for (int mid = left + 1; mid < right; mid++) {
				if (mid != left + 1 && num[mid] == num[mid - 1]) {
					continue;
				}
				sum = num[left] + num[mid] + num[right];
				if (sum == 0) {
					List<Integer> triplets = new ArrayList<>();
					triplets.add(num[left]);
					triplets.add(num[mid]);
					triplets.add(num[right]);

					results.add(triplets);
				}

				if (sum > 0) {
					right--;
					while (right > mid && num[right] == num[right + 1]) {
						right--;
					}
					mid--;
				}
			}
		}
		return results;
	}
}
