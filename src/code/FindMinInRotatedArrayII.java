package code;

public class FindMinInRotatedArrayII {
	public int findMin(int[] A) {
		int left = 0, right = A.length - 1;
		while (left < right && A[left] >= A[right]) {
			int mid = left + (right - left) / 2;
			if (A[mid] > A[right]) {
				left = mid + 1;
			} else if (A[mid] < A[left]) {
				right = mid;
			} else {
				left++;
			}
		}
		return A[left];
	}
}
