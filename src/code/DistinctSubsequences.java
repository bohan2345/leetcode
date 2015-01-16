package code;

public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
		int[][] A = new int[S.length() + 1][T.length() + 1];
        for (int i = 0; i <= S.length(); i++)
            A[i][0] = 1;
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                A[i][j] = A[i - 1][j];
                if (S.charAt(i - 1) == T.charAt(j - 1))
                    A[i][j] += A[i - 1][j - 1];
            }
        }
        return A[S.length()][T.length()];
	}
}
