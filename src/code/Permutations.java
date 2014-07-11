package code;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		List<Integer> a = new ArrayList<Integer>();
		results.add(a);
		for (int i = 0; i < num.length; i++) {
			int n = num[i];
			while (true) {
				List<Integer> cur = results.get(0);
				if (cur.size() == i+1)
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
}
