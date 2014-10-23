package code;

import java.util.HashSet;
import java.util.Set;

public class LongestNoRepeatingSubstring {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		Set<Character> set = new HashSet<Character>();
		int curLength = 1, maxLength = 1;
		int a = 0, b = 1;
		set.add(s.charAt(a));
		while (b < s.length()) {
			if (!set.contains(s.charAt(b))) {
				set.add(s.charAt(b));
				curLength++;
				b++;
			} else {
				maxLength = maxLength > curLength ? maxLength : curLength;
				set.remove(s.charAt(a));
				curLength--;
				a++;
			}
		}
		return maxLength > curLength ? maxLength : curLength;
	}
}
