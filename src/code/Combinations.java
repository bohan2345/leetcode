package code;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combinations = new ArrayList<List<Integer>>();

		if (n < 1 || k > n) {
			return combinations;
		}
		for (int i = 1; i <= n; i++) {
			List<Integer> combination = new ArrayList<Integer>();
			combination.add(i);
			combinations.add(combination);
		}
		List<List<Integer>> newCombinations = new ArrayList<List<Integer>>();
		for (int i = 1; i < k; i++) {
			newCombinations.clear();
			for (int j = 0; j < combinations.size(); j++) {
				List<Integer> temp = combinations.get(j);
				for (int x = temp.get(temp.size() - 1) + 1; x <= n; x++) {
					List<Integer> newCombination = new ArrayList<Integer>();
					newCombination.addAll(temp);
					newCombination.add(x);
					newCombinations.add(newCombination);
				}
			}
			combinations.clear();
			combinations.addAll(newCombinations);
		}
		return combinations;
	}

	public List<List<Integer>> combineII(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(n, 1, k, res, new ArrayList<Integer>());
		return res;
	}

	void dfs(int n, int i, int k, List<List<Integer>> res, List<Integer> tmp) {
		if (i > n && tmp.size() != k)
			return;
		if (tmp.size() == k) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		for (; i <= n; i++) {
			tmp.add(i);
			dfs(n, i + 1, k, res, tmp);
			tmp.remove(tmp.size() - 1);
		}
	}
}
