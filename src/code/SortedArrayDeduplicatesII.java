package code;

public class SortedArrayDeduplicatesII {
	public int removeDuplicates(int[] A) {
		if (A.length <= 2) {
			return A.length;
		}
		int count = 1;
		int i = 1, j = 1;
		while (j < A.length) {
			if (A[j] == A[j - 1]) {
				count++;
				if (count <= 2) {
					A[i] = A[j];
					i++;
				}
			} else {
				count = 1;
				A[i] = A[j];
				i++;
			}
			j++;
		}
		return i;
	}
}
