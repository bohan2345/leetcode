package code;

public class SortColors {
	public void sortColors(int[] A) {
		int o = 0, two = A.length - 1, p = 0;
		while (p <= two) {
			if (A[p] == 0) {
				A[p] = A[o];
				A[o] = 0;
				o++;
				p++;
			} else if (A[p] == 2) {
				A[p] = A[two];
				A[two] = 2;
				two--;
			} else {
				p++;
			}
		}
	}
}
