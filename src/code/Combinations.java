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
}
