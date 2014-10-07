package code;

import test.ListNode;

public class MergeSort {
	public void mergeSort(int[] A) {
		int n = A.length;
		int[] B = new int[n];
		// mergeSort(A, 0, n - 1, B);
		bottomUpSort(A, B);
	}
	
	public ListNode mergeSort(ListNode A, int len) {
		if (len == 1) {
			A.next = null;
			return A;
		}
		ListNode left = A;
		for (int i = 0; i < len / 2; i++) {
			A = A.next;
		}
		ListNode right = A;
		left = mergeSort(left, len / 2);
		right = mergeSort(right, len - len / 2);
		return merge(left, right);
	}

	public void mergeSort(int[] A, int left, int right, int[] B) {
		if (left >= right) {
			return;
		}
		int mid = (left + right) / 2;
		mergeSort(A, left, mid, B);
		mergeSort(A, mid + 1, right, B);
		merge(A, left, mid, right, B);
		for (int i = left; i <= right; i++) {
			A[i] = B[i];
		}
	}

	public ListNode merge(ListNode left, ListNode right) {
		ListNode last;
		if (left.val > right.val) {
			last = right;
			right = right.next;
		} else {
			last = left;
			left = left.next;
		}
		ListNode head = last;
		while (left != null && right != null) {
			if (left.val > right.val) {
				last.next = right;
				right = right.next;

			} else {
				last.next = left;
				left = left.next;
			}
			last = last.next;
		}
		if (left == null) {
			last.next = right;
		}
		if (right == null) {
			last.next = left;
		}
		return head;
	}

	public void merge(int A[], int left, int mid, int right, int B[]) {
		int x = left, y = mid + 1;
		for (int i = left; i <= right; i++) {
			if (y > right || A[x] <= A[y] && x <= mid) {
				B[i] = A[x];
				x++;
			} else {
				B[i] = A[y];
				y++;
			}
		}
	}

	public void bottomUpSort(int[] A, int[] B) {
		for (int width = 1; width < A.length; width = width * 2) {
			for (int i = 0; i < A.length; i = i + width * 2) {
				int mid = Math.min(i + width, A.length);
				int end = Math.min(i + 2 * width, A.length);
				merge(A, i, mid - 1, end - 1, B);
			}
			for (int i = 0; i < A.length; i++) {
				A[i] = B[i];
			}
		}
	}
}
