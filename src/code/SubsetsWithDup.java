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
	
	public List<List<Integer>> subsetsWithDupII(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        if (num == null || num.length == 0) {
            return res;
        }
        Arrays.sort(num);
        List<Integer> tmp = new ArrayList<>();
        res.add(tmp);
        helper(num, 0, res, tmp);
        return res;
    }
    
    void helper(int[] num, int i, List<List<Integer>> res, List<Integer> tmp) {
        if (i == num.length)
            return;
        for (; i < num.length; i++) {
            tmp.add(num[i]);
            res.add(new ArrayList<>(tmp));
            helper(num, i + 1, res, tmp);
            int x = tmp.get(tmp.size() - 1);
            tmp.remove(tmp.size() - 1);
            while (i + 1 < num.length && num[i + 1] == x)
                i++;
        }
    }
}
