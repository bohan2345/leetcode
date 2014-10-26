package code;

public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		int i = m, j = n;
		while (i > 0 && j > 0) {
			if (A[i - 1] >= B[j - 1]) {
				A[i + j - 1] = A[i - 1];
				i--;
			} else {
				A[i + j - 1] = B[j - 1];
				j--;
			}
		}
		if (i <= 0) {
			for (int x = j; x > 0; x--) {
				A[x - 1] = B[x - 1];
			}
		} else {

		}
	}
}
