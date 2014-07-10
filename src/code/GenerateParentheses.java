package code;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		generate(n, n, "", result);
		return result;
	}

	public void generate(int left, int right, String temp, List<String> result) {
		if (left > right) {
			return;
		}
		if (left > 0 && right > 0) {
			generate(left - 1, right, temp + "(", result);
			generate(left, right - 1, temp + ")", result);
		} else if (left == 0 && right > 0) {
			generate(left, right - 1, temp + ")", result);
		} else if (left == 0 && right == 0) {
			result.add(temp);
		}
	}
}
