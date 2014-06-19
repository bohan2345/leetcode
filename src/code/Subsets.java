package code;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {

	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> kong = new ArrayList<Integer>();
		result.add(kong);
		Arrays.sort(S);
		for (int i = 0; i < S.length; i++) {
			int num = S[i];
			temp = (ArrayList<ArrayList<Integer>>) result.clone();
			for (int j = 0; j < temp.size(); j++) {
				ArrayList<Integer> item = new ArrayList<Integer>();
				item=(ArrayList<Integer>) result.get(j).clone();
				item.add(num);
				result.add(item);
			}
		}
		return result;
	}

}
