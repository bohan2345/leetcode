package code;

public class SortedArrayDeduplicatesII {
	public int removeDuplicates(int[] A) {
		if (A.length <= 2) {
			return A.length;
		}
		int i = 1, j = 1, count = 1, last = A[0];
		while (i < A.length) {
			int cur = A[i];
			if (cur == last) {
				count++;
				if (count <= 2) {
					A[j] = A[i];
					j++;
				}
			} else {
				A[j] = A[i];
				j++;
				count = 1;
			}
			last = cur;
			i++;
		}
		return j;
	}
}
