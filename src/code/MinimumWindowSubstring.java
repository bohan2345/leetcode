package code;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		int left = 0, right = 0;
		int[] max = { Integer.MIN_VALUE + 1, 0 };
		Map<Character, Integer> window = new HashMap<>();
		for (int i = 0; i < T.length(); i++) {
			char c = T.charAt(i);
			if (window.containsKey(c)) {
				window.put(c, window.get(c) + 1);
			} else {
				window.put(c, 1);
			}
		}
		Map<Character, Integer> table = new HashMap<>();
		while (right < S.length()) {
			boolean f = false;
			while (right < S.length()) {
				char c = S.charAt(right);
				right++;
				if (table.containsKey(c)) {
					table.put(c, table.get(c) + 1);
				} else {
					table.put(c, 1);
				}
				if (satisfy(window, table)) {
					f = true;
					break;
				}
			}
			if (!f && right == S.length())
				break;
			while (left <= right) {
				char c = S.charAt(left);
				left++;
				table.put(c, table.get(c) - 1);
				if (window.containsKey(c) && window.get(c) > table.get(c)) {
					break;
				}
			}
			if (max[1] - max[0] > right - left) {
				max[0] = left - 1;
				max[1] = right;
			}
		}
		if (max[0] < 0) {
			max[0] = 0;
		}
		return S.substring(max[0], max[1]);
	}

	public boolean satisfy(Map<Character, Integer> map1, Map<Character, Integer> map2) {
		// if for each item in map2 >= map1 then return true
		for (char c : map1.keySet()) {
			if (!map2.containsKey(c)) {
				return false;
			}
			if (map2.get(c) < map1.get(c)) {
				return false;
			}
		}
		return true;
	}
}
