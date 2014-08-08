package code;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> kong = new ArrayList<Integer>();
		result.add(kong);
		Arrays.sort(S);
		for (int i = 0; i < S.length; i++) {
			int num = S[i];
			ArrayList<ArrayList<Integer>> lastResult = new ArrayList<ArrayList<Integer>>(result);
			for (int j = 0; j < lastResult.size(); j++) {
				ArrayList<Integer> temp = new ArrayList<Integer>(lastResult.get(j));
				temp.add(num);
				result.add(temp);
			}
		}
		return result;
	}
}
