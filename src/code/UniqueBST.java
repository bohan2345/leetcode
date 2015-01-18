package code;

public class UniqueBST {
	public int numTrees(int n) {
		int[] A = new int[n + 1];
		A[0] = 1;
		for (int i = 1; i <= n; i++)
			for (int j = 0; j < i; j++)
				A[i] += A[j] * A[i - 1 - j];
		return A[n];
	}
}
