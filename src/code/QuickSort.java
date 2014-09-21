package code;

public class QuickSort {
	public void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	// public void quickSort(int[] arr, int first, int last) {
	// // if (last < first)
	// // return;
	// int index = partition(arr, first, last);
	// if (first < index - 1)
	// quickSort(arr, first, index - 1);
	// if (index < last)
	// quickSort(arr, index, last);
	// }
	//
	// private int partition(int arr[], int left, int right) {
	// int i = left, j = right;
	// int tmp;
	// int pivot = arr[(i + j) / 2];
	//
	// while (i <= j) {
	// while (arr[i] < pivot)
	// i++;
	// while (arr[j] > pivot)
	// j--;
	// if (i <= j) {
	// tmp = arr[i];
	// arr[i] = arr[j];
	// arr[j] = tmp;
	// i++;
	// j--;
	// }
	// }
	//
	// return i;
	// }
	public void quickSort(int[] num, int left, int right) {
		int mid = patition(num, left, right);
		if (left < mid - 1) {
			quickSort(num, left, mid - 1);
		}
		if (right > mid) {
			quickSort(num, mid, right);
		}
	}

	public int patition(int[] num, int left, int right) {
		int mid = (left + right) / 2;
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
