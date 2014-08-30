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
}
