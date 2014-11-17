package code;

import java.util.HashMap;
import java.util.Map;

public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		if (!hasSameChars(s1, s2))
			return false;
		if (s1.equals(s2))
			return true;
		for (int mid1 = 1; mid1 < s1.length(); mid1++) {
			int mid2 = s1.length() - mid1;
			String sub11 = s1.substring(0, mid1);
			String sub12 = s1.substring(mid1);
			// no swap
			String sub21 = s2.substring(0, mid1);
			String sub22 = s2.substring(mid1);
			if (isScramble(sub11, sub21) && isScramble(sub12, sub22))
				return true;
			// swap
			String bsub21 = s2.substring(0, mid2);
			String bsub22 = s2.substring(mid2);
			if (isScramble(sub11, bsub22) && isScramble(sub12, bsub21))
				return true;
		}
		return false;
	}

	private boolean hasSameChars(String s1, String s2) {
		Map<Character, Integer> table = new HashMap<>();
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			if (table.containsKey(c))
				table.put(c, table.get(c) + 1);
			else
				table.put(c, 1);
		}
		for (int i = 0; i < s2.length(); i++) {
			char c2 = s2.charAt(i);
			if (table.containsKey(c2)) {
				table.put(c2, table.get(c2) - 1);
				if (table.get(c2) == 0)
					table.remove(c2);
			}
			else
				return false;
		}
		return table.size() == 0;
	}
}
