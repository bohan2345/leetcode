package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {
	public List<List<Integer>> subsetsWithDup(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> empty = new ArrayList<>();
		results.add(empty);
		int count = 0;
		for (int i = 0; i < num.length; i++) {
			int size = results.size();
			List<List<Integer>> lastResults = new ArrayList<>(results);
			if (i != 0 && num[i] == num[i - 1]) {
				for (int x = 1; x <= count; x++) {
					results.remove(size - x);
				}
			}
			count = 0;
			for (int j = 0; j < size; j++) {
				List<Integer> subset = new ArrayList<>(lastResults.get(j));
				subset.add(num[i]);
				results.add(subset);
				count++;
			}
		}
		return results;
	}
}
