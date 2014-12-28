package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<>();
		search(candidates, target, new ArrayList<Integer>(), 0, 0, res);
		return res;
	}

	void search(int[] candidates, int target, List<Integer> tmp, int sum, int i, List<List<Integer>> res) {
		if (sum >= target)
			return;
		for (; i < candidates.length; i++) {
			tmp.add(candidates[i]);
			if (sum + candidates[i] == target) {
				res.add(new ArrayList<Integer>(tmp));
			}
			search(candidates, target, tmp, sum + candidates[i], i + 1, res);
			int x = tmp.get(tmp.size() - 1);
			tmp.remove(tmp.size() - 1);
			while (i + 1 < candidates.length && candidates[i + 1] == x)
				i++;
		}
	}
}
