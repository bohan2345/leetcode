package code;

public class SearchRotatedArray {
	public int search(int[] A, int target) {
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

	public boolean searchII(int[] A, int target) {
		int left = 0, right = A.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (A[mid] == target) {
				return true;
			} else {
				if (A[mid] > A[left]) {
					if (target >= A[left] && target < A[mid]) {
						right = mid - 1;
					} else {
						left = mid + 1;
					}
				} else if (A[mid] < A[left]) {
					if (target > A[mid] && target <= A[right]) {
						left = mid + 1;
					} else {
						right = mid - 1;
					}
				} else {
					left++;
				}
			}
		}
		return false;
	}
}
