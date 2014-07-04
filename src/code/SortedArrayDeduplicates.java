package code;

public class SortedArrayDeduplicates {
	public int removeDuplicates(int[] A) {
		if (A.length <= 1)
			return A.length;
		int i = 1, j = 1;

		while (i < A.length) {
			if (A[i] != A[i - 1]) {
				A[j] = A[i];
				j++;
			}
			i++;
		}
		return j;
	}
}
