package code;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		if (s == null || s.length() == 0)
			return result;
		search(result, new ArrayList<String>(), s, 0);
		return result;
	}

	private void search(List<List<String>> result, List<String> tmp, String s, int i) {
		if (i == s.length()) {
			result.add(new ArrayList<String>(tmp));
			return;
		}
		for (int end = i + 1; end <= s.length(); end++) {
			String sub = s.substring(i, end);
			if (isPalindrome(sub)) {
				tmp.add(sub);
				search(result, tmp, s, end);
				tmp.remove(tmp.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String s) {
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		return s.equals(sb.toString());
	}
}
