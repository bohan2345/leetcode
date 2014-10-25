package code;

import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		boolean[] table = new boolean[s.length() + 1];
		table[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			boolean f = false;
			for (int l = 1; l <= i; l++) {
				String substr = s.substring(i - l, i);
				f = f || (dict.contains(substr) && table[i - l]);
			}
			table[i] = f;
		}
		return table[s.length()];
	}
}
