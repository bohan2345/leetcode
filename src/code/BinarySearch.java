package code;

public class BinarySearch {
	public int binarySearch(int[] A, int left, int right, int target) {
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		if (A[mid] > target) {
			return binarySearch(A, left, mid - 1, target);
		} else if (A[mid] < target) {
			return binarySearch(A, mid + 1, right, target);
		} else
			return mid;
	}

	public int binarySearch(int[] A, int target) {
		int left = 0, right = A.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (target == A[mid]) {
				return mid;
			} else {
				if (target > A[mid]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}
}
