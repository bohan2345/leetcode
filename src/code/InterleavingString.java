package code;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s3.length() != s1.length() + s2.length())
			return false;
		boolean[][] A = new boolean[s1.length() + 1][s2.length() + 1];
		A[0][0] = true;
		for (int a = 1; a <= s1.length(); a++) {
			A[a][0] = A[a - 1][0] && s1.charAt(a - 1) == s3.charAt(a - 1);
		}
		for (int b = 1; b <= s2.length(); b++) {
			A[0][b] = A[0][b - 1] && s2.charAt(b - 1) == s3.charAt(b - 1);
		}
		for (int a = 1; a <= s1.length(); a++) {
			for (int b = 1; b <= s2.length(); b++) {
				A[a][b] = (A[a - 1][b] && s1.charAt(a - 1) == s3.charAt(a + b - 1)) || (A[a][b - 1] && s2.charAt(b - 1) == s3.charAt(a + b - 1));
			}
		}
		return A[s1.length()][s2.length()];
	}
}
