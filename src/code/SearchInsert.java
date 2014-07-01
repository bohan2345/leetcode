package code;

import java.util.Arrays;

public class SearchInsert {
	public int searchInsert(int[] A, int target) {
		
		int mid = A.length / 2;
		if (A[mid] > target) {
			int[] a = Arrays.copyOfRange(A, 0, mid);
			return -searchInsert(a,target);
		} else if (A[mid] < target) {
			int[] a = Arrays.copyOfRange(A, mid, A.length);
			return searchInsert(a,target);
		} else
			return mid;
	}
}
