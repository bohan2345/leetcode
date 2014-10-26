package code;

public class SearchforRange {
	public int[] searchRange(int[] A, int target) {
		int[] result = { -1, -1 };
		int i = binarySearch(A, target);
		if (i == -1) {
			return result;
		}
		int left = i, right = i;
		while (left >= 0 && A[left] == A[i]) {
			left--;
		}
		result[0] = left + 1;
		while (right < A.length && A[right] == A[i]) {
			right++;
		}
		result[1] = right - 1;
		return result;
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
