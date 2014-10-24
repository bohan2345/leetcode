package code;

public class KthElementInTwoArray {
	public int find(int[] A, int[] B, int k) {
		return find(A, B, 0, A.length - 1, 0, B.length - 1, k);
	}

	public int find(int[] A, int[] B, int aleft, int aright, int bleft, int bright, int k) {
		int a = aright - aleft + 1;
		int b = bright - bleft + 1;
		if (a < 1) {
			return B[bleft + k - 1];
		}
		if (b < 1) {
			return A[aleft + k - 1];
		}
		if (k <= 1) {
			return Math.min(A[aleft], B[bleft]);
		}
		int index = Math.min(Math.min(a, b), k / 2);
		if (A[aleft + index - 1] > B[bleft + index - 1]) {
			return find(A, B, aleft, aright, bleft + index, bright, k - index);
		} else {
			return find(A, B, aleft + index, aright, bleft, bright, k - index);
		}
	}
}
