package code;

public class LongestPalindromic {
	public String longestPalindrome(String s) {
		boolean[][] table = new boolean[s.length()][s.length()];
		int max = 1;
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			table[i][i] = true;
		}
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				table[i][i + 1] = true;
				max = 2;
				index = i;
			}
		}
		for (int len = 3; len <= s.length(); len++) {
			for (int i = 0; i < s.length() - len + 1; i++) {
				int j = i + len - 1;
				if (s.charAt(i) == s.charAt(j) && table[i + 1][j - 1]) {
					table[i][j] = true;
					max = len;
					index = i;
				}
			}
		}
		if (index + max == s.length())
			return s.substring(index);
		else
			return s.substring(index, index + max);
	}
}
