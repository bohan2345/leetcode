package code;

public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		int top = 0, bot = matrix.length - 1;
		int row = 0;
		while (top <= bot) {
			int mid = top + (bot - top) / 2;
			if (mid >= matrix.length - 1) {
				row = mid;
				break;
			}
			if (target >= matrix[mid][0] && target < matrix[mid + 1][0]) {
				row = mid;
				break;
			} else {
				if (target < matrix[mid][0]) {
					bot = mid - 1;
				} else {
					top = mid + 1;
				}
			}
		}
		return binarySearch(matrix[row], target);
	}

	public boolean binarySearch(int[] A, int target) {
		int left = 0, right = A.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (target == A[mid]) {
				return true;
			} else {
				if (target > A[mid])
					left = mid + 1;
				else
					right = mid - 1;
			}
		}
		return false;
	}
}
