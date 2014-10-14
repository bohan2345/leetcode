package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(results, candidates, target, new ArrayList<Integer>(), 0, 0);
        return results;
    }
    void dfs(List<List<Integer>> results, int[] A, int target, List<Integer> tmp, int sum, int index) {
        if (sum == target) {
            List<Integer> a = new ArrayList<>(tmp);
            results.add(a);
            return;
        } else if (sum > target) {
            return;
        }
        for (int i = index; i < A.length; i++) {
            tmp.add(A[i]);
            dfs(results, A , target, tmp, sum + A[i], i);
            tmp.remove(tmp.size() - 1);
        }
        return;
    }
}
