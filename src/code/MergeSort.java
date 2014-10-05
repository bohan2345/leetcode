package code;

public class MergeSort {
	public void mergeSort(int[] A) {
		int n = A.length;
		int[] B = new int[n];
		mergeSort(A, 0, n - 1, B);
	}

	public void mergeSort(int[] A, int left, int right, int[] B) {
		if (left >= right) {
			return;
		}
		int mid = (left + right) / 2;
		mergeSort(A, left, mid, B);
		mergeSort(A, mid + 1, right, B);
		merge(A, left, mid, right, B);
		for (int i = left; i <= right; i++) {
			A[i] = B[i];
		}
	}

	public void merge(int A[], int left, int mid, int right, int B[]) {
		int x = left, y = mid + 1;
		for (int i = left; i <= right; i++) {
			if (y > right || A[x] <= A[y] && x <= mid) {
				B[i] = A[x];
				x++;
			} else {
				B[i] = A[y];
				y++;
			}
		}
	}
}
