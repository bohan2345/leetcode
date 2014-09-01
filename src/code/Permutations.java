package code;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		List<Integer> a = new ArrayList<Integer>();
		results.add(a);
		for (int i = 0; i < num.length; i++) {
			int n = num[i];
			while (true) {
				List<Integer> cur = results.get(0);
				if (cur.size() == i + 1)
					break;
				for (int p = 0; p <= cur.size(); p++) {
					List<Integer> temp = new ArrayList<Integer>(cur);
					temp.add(p, n);
					results.add(temp);
				}
				results.remove(0);
			}
		}
		return results;
	}

	public List<List<Integer>> permuteII(int[] num) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		Set<Integer> visited = new LinkedHashSet<Integer>();
		dfs(num, results, temp, visited);
		return results;
	}

	public void dfs(int[] num, List<List<Integer>> results, List<Integer> temp, Set<Integer> visited) {
		if (visited.size() == num.length) {
			List<Integer> p = new ArrayList<Integer>(temp);
			results.add(p);
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (visited.contains(num[i])) {
				continue;
			}
			temp.add(num[i]);
			visited.add(num[i]);
			dfs(num, results, temp, visited);
			temp.remove(temp.size() - 1);
			visited.remove(num[i]);
		}
		return;
	}
}
