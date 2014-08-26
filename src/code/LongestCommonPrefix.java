package code;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		String prefix = "";
		if (strs == null || strs.length == 0) {
			return prefix;
		}
		int n = 0;
		while (n < strs[0].length()) {
			char c = strs[0].charAt(n);
			char cc = strs[0].charAt(n);
			for (int i = 0; i < strs.length; i++) {
				if (n == strs[i].length()) {
					return prefix;
				}
				cc = strs[i].charAt(n);
				if (c != cc) {
					return prefix;
				}
			}
			c = cc;
			prefix += String.valueOf(c);
			n++;
		}
		return prefix;
	}
}
