package code;

public class SearchInsert {
	public int searchInsert(int[] A, int target) {
		if (A == null || A.length == 0)
			return 0;
		int left = 0, right = A.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (target == A[mid])
				return mid;
			else {
				if (target > A[mid]) {
					left = mid + 1;
					if (left < A.length && A[left] > target)
						return mid + 1;
				} else {
					right = mid - 1;
					if (right >= 0 && A[right] < target)
						return mid;
				}
			}
		}
		return target > A[0] ? A.length : 0;
	}
}
