package code;

public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
		int[][] A = new int[S.length() + 1][T.length() + 1];
		A[0][0] = 1;
		for (int i = 1; i <= S.length(); i++) {
			A[i][0] = 1;
		}
		for (int i = 1; i <= T.length(); i++) {
			A[0][i] = 0;
		}
		for (int t = 1; t <= T.length(); t++) {
			for (int s = 1; s <= S.length(); s++) {
				if (S.charAt(s - 1) == T.charAt(t - 1)) {
					A[s][t] = A[s - 1][t] + A[s - 1][t - 1];
				} else {
					A[s][t] = A[s - 1][t];
				}
			}
		}
		return A[S.length()][T.length()];
	}
}
