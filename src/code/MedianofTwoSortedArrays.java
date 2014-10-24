package code;

public class MedianofTwoSortedArrays {
	public double findMedianSortedArrays(int[] A, int[] B) {
		int length = A.length + B.length;
		if (A.length == 0) {
			if (B.length % 2 == 0)
				return (B[length / 2] + B[length / 2 - 1]) / 2.0;
			else
				return B[length / 2];
		} else if (B.length == 0) {
			if (A.length % 2 == 0)
				return (A[length / 2] + A[length / 2 - 1]) / 2.0;
			else
				return A[length / 2];
		}
		if (length % 2 == 0)
			return (find(A, B, 0, A.length - 1, 0, B.length - 1, length / 2) + find(A, B, 0, A.length - 1, 0, B.length - 1, length / 2 + 1)) / 2.0;
		else
			return (double) find(A, B, 0, A.length - 1, 0, B.length - 1, length / 2 + 1);
	}

	public int find(int[] A, int[] B, int aleft, int aright, int bleft, int bright, int k) {
		int a = aright - aleft + 1;
		int b = bright - bleft + 1;
		if (a == 0) {
			return B[bleft + k - 1];
		}
		if (b == 0) {
			return A[aleft + k - 1];
		}
		if (k <= 1) {
			return Math.min(A[aleft], B[bleft]);
		}
		int index = Math.min(k / 2, Math.min(a, b));
		if (A[aleft + index - 1] < B[bleft + index - 1]) {
			return find(A, B, aleft + index, aright, bleft, bright, k - index);
		} else {
			return find(A, B, aleft, aright, bleft + index, bright, k - index);
		}
	}
}
