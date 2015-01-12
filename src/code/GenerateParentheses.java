package code;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		generate(n, n, "", result);
		return result;
	}

	// public void generate(int left, int right, String temp, List<String> result) {
	// if (left > right) {
	// return;
	// }
	// if (left > 0 && right > 0) {
	// generate(left - 1, right, temp + "(", result);
	// generate(left, right - 1, temp + ")", result);
	// } else if (left == 0 && right > 0) {
	// generate(left, right - 1, temp + ")", result);
	// } else if (left == 0 && right == 0) {
	// result.add(temp);
	// }
	// }

	public void generate(int left, int right, String tmp, List<String> result) {
		if (left > right)
			return;
		if (left == 0 && right == 0) {
			result.add(tmp);
			return;
		}
		if (left > 0)
			generate(left - 1, right, tmp + "(", result);
		if (right > 0)
			generate(left, right - 1, tmp + ")", result);
	}

	public List<String> generateParenthesisII(int n) {
		List<String> res = new ArrayList<>();
		helper(0, 0, res, new StringBuilder(), n);
		return res;
	}

	void helper(int need, int complete, List<String> res, StringBuilder tmp, int n) {
		if (complete > need) {
			tmp.deleteCharAt(tmp.length() - 1);
			return;
		}
		if (need < n && complete < n) {
			tmp.append('(');
			helper(need + 1, complete, res, tmp, n);
			tmp.append(')');
			helper(need, complete + 1, res, tmp, n);
		} else if (need == n && complete < n) {
			tmp.append(')');
			helper(need, complete + 1, res, tmp, n);
		} else if (need == n && complete == n)
			res.add(tmp.toString());
		if (tmp.length() != 0)
			tmp.deleteCharAt(tmp.length() - 1);
	}
}
