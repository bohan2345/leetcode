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
}
