package code;

public class SearchRotatedArray {
	public int searchII(int[] A, int target) {
		int left = 0, right = A.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (A[mid] == target) {
				return mid;
			} else {
				if (A[mid] >= A[left]) {
					if (target >= A[left] && target < A[mid]) {
						right = mid - 1;
					} else {
						left = mid + 1;
					}
				} else {
					if (target > A[mid] && target <= A[right]) {
						left = mid + 1;
					} else {
						right = mid - 1;
					}
				}
			}
		}
		return -1;
	}

	public int search(int[] A, int target) {
		if (A.length == 0) {
			return -1;
		}
		return search(A, target, 0, A.length - 1);
	}

	public int search(int[] A, int target, int left, int right) {
		if (left > right) {
			return -1;
		}
		int mid = left + (right - left) / 2;
		if (A[mid] == target) {
			return mid;
		} else {
			if (A[mid] >= A[left]) {
				if (target > A[mid]) {
					return search(A, target, mid + 1, right);
				} else {
					int tmp = search(A, target, mid + 1, right);
					return tmp != -1 ? tmp : search(A, target, left, mid - 1);
				}
			} else {
				if (target < A[mid]) {
					return search(A, target, left, mid - 1);
				} else {
					int tmp = search(A, target, mid + 1, right);
					return tmp != -1 ? tmp : search(A, target, left, mid - 1);
				}
			}
		}
	}
}
