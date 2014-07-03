package code;

public class RemoveElement {
	public int removeElement(int[] A, int elem) {
		int i = 0, j = 0;
		while (j < A.length) {
			if (A[j] != elem) {
				A[i] = A[j];
				i++;
			}
			j++;
		}
		return i;
	}

	public int removeElementII(int[] A, int elem) {
		if (A.length == 0)
			return 0;
		int result = A.length;
		int d = elem + 1;

		for (int i = 0; i < A.length; i++) {
			if (A[i] == elem) {
				A[i] = d;
				result--;
			}
		}
		return result;
	}
}
