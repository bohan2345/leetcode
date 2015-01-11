package code;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		Map<Character, Integer> need = new HashMap<>();
		for (int i = 0; i < T.length(); i++) {
			char c = T.charAt(i);
			if (need.containsKey(c)) {
				need.put(c, need.get(c) + 1);
			} else {
				need.put(c, 1);
			}
		}
		int l = 0, r = 0, min = S.length() + 1, start = 0;
		while (r <= S.length()) {
			if (isSatisfy(need)) {
				if (min > r - l) {
					min = r - l;
					start = l;
				}
				if (need.containsKey(S.charAt(l))) {
					need.put(S.charAt(l), need.get(S.charAt(l)) + 1);
				}
				l++;
				continue;
			}
			if (r < S.length() && need.containsKey(S.charAt(r))) {
				int n = need.get(S.charAt(r)) - 1;
				need.put(S.charAt(r), n);
			} 
			r++;
		}
		return min <= S.length() ? S.substring(start, start + min) : "";
	}

	boolean isSatisfy(Map<Character, Integer> table) {
		for (char c : table.keySet()) {
			if (table.get(c) > 0)
				return false;
		}
		return true;
	}
}
