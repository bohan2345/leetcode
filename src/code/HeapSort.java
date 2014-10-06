package code;

public class HeapSort {
	public void heapSort(int[] A) {
		heapify(A);
		for (int last = A.length - 1; last > 0; last--) {
			swap(A, 0, last);
			shiftDown(A, 0, last);
		}
	}

	// build heap
	public void heapify(int[] A) {
		int count = A.length;
		// find the last element's parent, last element is at index (count - 1)
		// parent is at (index - 1) / 2
		int index = (count - 2) / 2;
		for (int i = index; i >= 0; i--) {
			shiftDown(A, i, count);
		}
	}

	// reorder the heap, maintain a max-heap
	public void shiftDown(int[] A, int index, int len) {
		int root = index;
		while (root * 2 + 1 < len) { // ensure this root has at least one child.
			int left = root * 2 + 1;
			int swap = left;
			if (left + 1 < len) { // right child exist
				int right = left + 1;
				swap = A[left] > A[right] ? left : right;
			}
			if (A[root] < A[swap]) {
				swap(A, root, swap);
				root = swap;
			} else {
				break;
			}
		}
	}

	public void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
}
