package code;

public class SearchRotatedArray {
	public int search(int[] A, int target) {
		if (A.length < 1) {
			return -1;
		}
		return search(A, target, 0, A.length - 1);
	}

	public int search(int[] A, int target, int left, int right) {
		if (left > right)
			return -1;
		int mid = (left + right) / 2;
		if (A[mid] > A[left]) {
			if (target > A[mid]) {
				return search(A, target, mid + 1, right);
			} else if (target == A[mid]) {
				return mid;
			} else {
				int result = search(A, target, mid + 1, right);
				if (result == -1) {
					return search(A, target, left, mid - 1);
				} else {
					return result;
				}
			}
		} else {
			if (target < A[mid]) {
				return search(A, target, left, mid - 1);
			} else if (target == A[mid]) {
				return mid;
			} else {
				int result = search(A, target, mid + 1, right);
				if (result == -1) {
					return search(A, target, left, mid - 1);
				} else {
					return result;
				}
			}
		}
		// if (A[mid] > A[right]) {
		// } else {
		// }
		// return 0;
	}
}
