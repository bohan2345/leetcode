package code;

public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length < 1) {
			return false;
		}
		if (target < matrix[0][0]) {
			return false;
		}
		// search for row
		int[] A = new int[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			A[i] = matrix[i][0];
		}
		int row = binarySearch(A, target, 0, A.length - 1);
		int col = binarySearch(matrix[row], target);
		if (col == -1) {
			return false;
		} else
			return true;
	}

	public int binarySearch(int[] A, int target, int left, int right) {
		if (A.length < 1)
			return 0;
		if (left > right) {
			return right;
		}
		int mid = left + (right - left) / 2;
		if (target > A[mid])
			return binarySearch(A, target, mid + 1, right);
		else if (target < A[mid])
			return binarySearch(A, target, left, mid - 1);
		else
			return mid;
	}

	public int binarySearch(int[] A, int target) {
		int left = 0, right = A.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (target > A[mid])
				left = mid + 1;
			else if (target < A[mid])
				right = mid - 1;
			else
				return mid;
		}
		return -1;
	}
}
