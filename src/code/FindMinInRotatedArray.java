package code;

public class FindMinInRotatedArray {
	public int findMin(int[] num) {
		int left = 0, right = num.length - 1;
		while (right > left && num[left] > num[right]) {
			int mid = left + (right - left) / 2;
			if (num[mid] < num[right]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return num[left];
	}

	public int findMinII(int[] num) {
		return findMin(num, 0, num.length - 1);
	}

	public int findMin(int[] A, int left, int right) {
		if (right - left < 2) {
			return A[left] < A[right] ? A[left] : A[right];
		}
		int mid = left + (right - left) / 2;
		if (A[mid] < A[mid + 1] && A[mid] < A[mid - 1]) {
			return A[mid];
		} else {
			if (A[mid] > A[right]) {
				return findMin(A, mid + 1, right);
			} else {
				return findMin(A, left, mid - 1);
			}
		}
	}
}
