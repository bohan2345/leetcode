package code;

import java.util.ArrayList;
import java.util.HashSet;
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
        List<List<Integer>> res = new ArrayList<>();
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
            }
        }
    }
}