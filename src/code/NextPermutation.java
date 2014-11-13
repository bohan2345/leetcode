package code;

public class NextPermutation {
	public void nextPermutation(int[] num) {
		int left = findPartitionNumber(num);
		if (left != -1) {
			int i = findChangeNumber(num, num[left]);
			int tmp = num[left];
			num[left] = num[i];
			num[i] = tmp;
		}
		reverse(num, left + 1, num.length - 1);
	}

	private int findPartitionNumber(int[] num) {
		for (int i = num.length - 1; i > 0; i--) {
			if (num[i - 1] < num[i])
				return i - 1;
		}
		return -1;
	}

	private int findChangeNumber(int[] num, int a) {
		for (int i = num.length - 1; i >= 0; i--) {
			if (num[i] > a)
				return i;
		}
		return -1;
	}

	private void reverse(int[] num, int left, int right) {
		while (left < right) {
			int tmp = num[left];
			num[left] = num[right];
			num[right] = tmp;
			left++;
			right--;
		}
	}
}
