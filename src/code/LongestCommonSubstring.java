package code;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubstring {
	public List<String> findLongestSubstring(String A, String B) {
		int[][] table = new int[A.length()][B.length()];
		List<String> results = new ArrayList<>();
		int max = 0;
		List<Integer> pos = new ArrayList<>();
		for (int a = 0; a < A.length(); a++) {
			for (int b = 0; b < B.length(); b++) {
				if (A.charAt(a) == B.charAt(b)) {
					if (a == 0 || b == 0) {
						table[a][b] = 1;
					} else {
						table[a][b] = table[a - 1][b - 1] + 1;
					}
					if (table[a][b] > max) {
						pos.clear();
						pos.add(a);
						max = table[a][b];
					} else if (table[a][b] == max) {
						pos.add(a);
					}
				}
			}
		}
		for (int i = 0; i < pos.size(); i++) {
			String tmp = A.substring(pos.get(i) + 1 - max, pos.get(i) + 1);
			results.add(tmp);
		}
		return results;
	}
}
