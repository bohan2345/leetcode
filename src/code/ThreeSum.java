package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	// public List<List<Integer>> threeSum(int[] num) {
	// List<List<Integer>> results = new ArrayList<>();
	// if (num == null || num.length == 0) {
	// return results;
	// }
	// Arrays.sort(num);
	// int sum = 0;
	// for (int left = 0; left < num.length - 2; left++) {
	// if (left != 0 && num[left] == num[left - 1]) {
	// continue;
	// }
	// int right = num.length - 1;
	// for (int mid = left + 1; mid < right; mid++) {
	// if (mid != left + 1 && num[mid] == num[mid - 1]) {
	// continue;
	// }
	// sum = num[left] + num[mid] + num[right];
	// if (sum == 0) {
	// List<Integer> triplets = new ArrayList<>();
	// triplets.add(num[left]);
	// triplets.add(num[mid]);
	// triplets.add(num[right]);
	//
	// results.add(triplets);
	// }
	//
	// if (sum > 0) {
	// right--;
	// while (right > mid && num[right] == num[right + 1]) {
	// right--;
	// }
	// mid--;
	// }
	// }
	// }
	// return results;
	// }
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> results = new ArrayList<>();
		Arrays.sort(num);
		int sum = 0;
		int left = 0;
		while (left < num.length - 2) {
			int mid = left + 1, right = num.length - 1;
			while (left + 1 < right && mid < right) {
				sum = num[left] + num[right] + num[mid];
				if (sum == 0) {
					List<Integer> triplet = new ArrayList<>();
					triplet.add(num[left]);
					triplet.add(num[mid]);
					triplet.add(num[right]);
					results.add(triplet);
					int i = mid + 1;
					while (i < num.length && num[i] == num[mid]) {
						i++;
					}
					mid = i;
				} else if (sum > 0) {
					int j = right - 1;
					while (j > 0 && num[j] == num[right]) {
						j--;
					}
					right = j;
					mid = left + 1;
				} else {
					int k = mid + 1;
					while (k < num.length && num[k] == num[mid]) {
						k++;
					}
					mid = k;
				}
			}
			int l = left + 1;
			while (l < num.length - 2 && num[l] == num[left]) {
				l++;
			}
			left = l;
		}
		return results;
	}
}
