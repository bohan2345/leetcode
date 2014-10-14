package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> results = new ArrayList<>();
		Arrays.sort(num);
		dfs(results, num, target, 0, 0, new ArrayList<Integer>());
		return results;
	}

	void dfs(List<List<Integer>> results, int[] A, int target, int sum, int index, List<Integer> tmp) {
		if (sum == target) {
			List<Integer> n = new ArrayList<>(tmp);
			results.add(n);
			return;
		} else if (sum > target) {
			return;
		}
		for (int i = index; i < A.length; i++) {
			tmp.add(A[i]);
			dfs(results, A, target, sum + A[i], i + 1, tmp);
			tmp.remove(tmp.size() - 1);
			while (i < A.length - 1 && A[i + 1] == A[i]) {
				i++;
			}
		}
		return;
	}
}
