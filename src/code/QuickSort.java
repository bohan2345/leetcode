package code;

public class QuickSort {
	public void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	public void quickSort(int[] arr, int first, int last) {
		if (last < first)
			return;
		int index = partition(arr, first, last);
		if (first < index - 1)
			quickSort(arr, first, index - 1);
		if (index < last)
			quickSort(arr, index, last);
	}

	private int partition(int[] arr, int first, int last) {
		int temp, i = first, j = last;
		int mid = arr[(i + j) / 2];

		while (i <= j) {
			while (arr[i] < mid) {
				i++;
			}
			while (arr[j] > mid) {
				j--;
			}
			if (i <= i) {
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				i++;
				j--;
			}
		}
		return i;
	}
}
