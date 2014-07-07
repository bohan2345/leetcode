package code;

public class QuickSort {
	public void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	public void quickSort(int[] arr, int first, int last) {
		// if (last < first)
		// return;
		int index = partitionII(arr, first, last);
		if (first < index - 1)
			quickSort(arr, first, index - 1);
		if (index < last)
			quickSort(arr, index, last);
	}

	private int partitionII(int[] arr, int first, int last) {
		int temp, i = first, j = last;
		int mid = arr[(i + j) / 2];

		while (i <= j) {
			while (arr[i] < mid)
				i++;

			while (arr[j] > mid)
				j--;

			if (i <= j) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		return i;
	}

	int partition(int arr[], int left, int right) {
		int i = left, j = right;
		int tmp;
		int pivot = arr[(i + j) / 2];

		while (i <= j) {
			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}

		return i;
	}
}
