package code;

import test.ListNode;

public class QuickSort {
	public void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	public void quickSort(ListNode head) {
		// TODO: need implement
	}

	public void quickSort(int[] num, int left, int right) {
		if (left >= right)
			return;
		int mid = patition(num, left, right);
		quickSort(num, left, mid - 1);
		quickSort(num, mid, right);
	}

	public int patition(int[] num, int left, int right) {
		// Selecting a pivot element is also complicated by the existence of integer overflow.
		// If the boundary indices of the subarray being sorted are sufficiently large, the naïve expression for the
		// middle index, (left + right)/2, will cause overflow and provide an invalid pivot index.
		// This can be overcome by using, for example, left + (right-left)/2 to index the middle element
		int mid = left + (right - left) / 2;
		int val = num[mid];
		while (left <= right) {
			while (num[left] < val) {
				left++;
			}
			while (num[right] > val) {
				right--;
			}
			if (left <= right) {
				int temp = num[left];
				num[left] = num[right];
				num[right] = temp;
				left++;
				right--;
			}
		}
		return left;
	}
}
