package code;

import java.util.ArrayList;
import java.util.List;

public class MaximumGap {
	public int maximumGap(int[] num) {
		if (num == null || num.length <= 1)
			return 0;
		int max = num[0], min = num[0];
		for (int n : num) {
			max = Math.max(max, n);
			min = Math.min(min, n);
		}

		int size = (int) Math.ceil((max - min) * 1.0 / (num.length - 1));
		int n = (max - min) / size + 1;
		List<List<Integer>> buckets = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			buckets.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < num.length; i++) {
			int x = (num[i] - min) / size;
			buckets.get(x).add(num[i]);
		}
		int gap = 1;
		int bmax = 0, bmin = max, lmax = min;
		for (int i = 0; i < buckets.size(); i++) {
			List<Integer> bucket = buckets.get(i);
			if (bucket.size() == 0)
				continue;
			bmax = 0;
			bmin = max;
			for (int j = 0; j < bucket.size(); j++) {
				bmax = Math.max(bmax, bucket.get(j));
				bmin = Math.min(bmin, bucket.get(j));
			}
			gap = Math.max(gap, bmin - lmax);
			lmax = bmax;
		}
		return gap;
	}

	public static void main(String[] args) {
		int[] A = { 1, 10000000 };
		int x = new MaximumGap().maximumGap(A);
		System.out.println(x);
	}
}
