package code;

public class SearchforRange {
	public int[] searchRange(int[] A, int target) {
		int[] range = { -1, -1 };
		if (A == null || A.length == 0) {
			return range;
		}
		int t = binarySearch(A, 0, A.length - 1, target);
		if (t == -1) {
			return range;
		} else {
			int i = t, j = t;
			while (true) {
				if (i > A.length - 1) {
					i--;
					break;
				}
				if (A[i] == A[t]) {
					i++;
				} else {
					i--;
					break;
				}
			}
			while (true) {
				if (j < 0) {
					j++;
					break;
				}
				if (A[j] == A[t]) {
					j--;
				} else {
					j++;
					break;
				}
			}
			range[0] = j;
			range[1] = i;
			return range;
		}
	}

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
}
