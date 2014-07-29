package code;

public class SearchRotatedArray {
	public boolean searchII(int[] A, int target) {
		if (A.length < 1) {
			return false;
		}
		int x = search(A, target, 0, A.length - 1);
		if (x == -1)
			return false;
		else
			return true;
	}

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
			if (mid == left){
				if (target == A[mid]) {
					return mid;
				} else if (mid + 1 < A.length && target == A[mid + 1]) {
					return mid + 1;
				} else
					return -1;
			}
			
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
	}
}
