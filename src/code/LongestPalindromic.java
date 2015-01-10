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
		return s.substring(index, index + max);
	}

	public String longestPalindromeII(String s) {
		int[][] A = new int[s.length()][s.length()];
		int max = 1, x = 0;
		for (int i = 0; i < s.length(); i++) {
			A[i][i] = 1;
		}
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				A[i][i + 1] = 2;
				max = 2;
				x = i;
			}
		}
		for (int i = s.length() - 3; i >= 0; i--) {
			for (int j = i + 2; j < s.length(); j++) {
				if (A[i + 1][j - 1] > 0 && s.charAt(i) == s.charAt(j))
					A[i][j] = A[i + 1][j - 1] + 2;
				if (A[i][j] > max) {
					max = A[i][j];
					x = i;
				}
			}
		}
		return s.substring(x, x + max);
	}
}
