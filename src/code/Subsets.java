package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	public List<List<Integer>> subsetsII(int[] S) {
        List<List<Integer>> res = new ArrayList<>();
        if (S == null || S.length == 0)
            return res;
        Arrays.sort(S);
        List<Integer> tmp = new ArrayList<>();
        res.add(tmp);
        helper(S, res, tmp, 0);
        return res;
    }
    
    void helper(int[] S, List<List<Integer>> res, List<Integer> tmp, int i) {
        if (tmp.size() == S.length) {
            return;
        }
        for (; i < S.length; i++) {
            tmp.add(S[i]);
            res.add(new ArrayList<Integer>(tmp));
            helper(S, res, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
