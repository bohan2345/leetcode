package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(num);
		dfs(num, new HashSet<Integer>(), res, new ArrayList<Integer>());
		return res;
	}

	void dfs(int[] num, Set<Integer> used, List<List<Integer>> res, List<Integer> tmp) {
		if (used.size() == num.length) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (!used.contains(i)) {
				tmp.add(num[i]);
				used.add(i);
				dfs(num, used, res, tmp);
				tmp.remove(tmp.size() - 1);
				used.remove(i);
				while (i + 1 < num.length && num[i] == num[i + 1])
					i++;
			}
		}
	}
}
