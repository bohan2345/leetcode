package code;

public class FindPeakElement {
	public int findPeakElement(int[] num) {
		if (num == null || num.length == 0) {
			throw new IllegalArgumentException();
		}
		if (num.length == 1)
			return 0;
		int left = 0, right = num.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (mid == 0) {
				if (num[mid] > num[mid + 1])
					return mid;
				else
					left = mid + 1;
			} else if (mid == num.length - 1) {
				if (num[mid] > num[mid - 1])
					return mid;
				else
					right = mid - 1;
			} else {
				if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1])
					return mid;
				else if (num[mid] > num[mid - 1] && num[mid] < num[mid + 1])
					left = mid + 1;
				else if (num[mid] > num[mid + 1] && num[mid] < num[mid - 1])
					right = mid - 1;
				else
					left++;
			}
		}
		return -1;
	}
}
