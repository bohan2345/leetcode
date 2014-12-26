package code;

public class MedianofTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
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
			return (find(A, B, 0, 0, length / 2 + 1) + find(A, B, 0, 0, length / 2)) / 2.0;
		else
			return find(A, B, 0, 0, length / 2 + 1) * 1.0;
	}

	public int find(int A[], int B[], int aleft, int bleft, int k) {
		int a = A.length - aleft;
		int b = B.length - bleft;
		if (a == 0)
			return B[bleft + k - 1];
		if (b == 0)
			return A[aleft + k - 1];
		if (k <= 1)
			return Math.min(A[aleft], B[bleft]);
		int i = Math.min(k / 2, Math.min(a, b));
		if (A[aleft + i - 1] > B[bleft + i - 1]) {
			return find(A, B, aleft, bleft + i, k - i);
		} else {
			return find(A, B, aleft + i, bleft, k - i);
		}
	}

	public static void main(String[] args) {
		int[] A = { 1, 2 };
		int[] B = { 1, 2 };

		double x = new MedianofTwoSortedArrays().findMedianSortedArrays(A, B);
		System.out.println(x);
	}
}
