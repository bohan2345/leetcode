package tc;

public class MS {
	public static void main(String[] args) {
		int[][] A = { { 0, 0, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 0, 1 }, { 1, 1, 1, 1 } };
		MS test = new MS();
		test.removeAllMarked(A);
		System.out.println(A);
	}

	public void removeAllMarked(int[][] A) {
		int i = 0, j = 0;
		while (i < A.length && j < A.length) {
			if (!isAllMarked(A[i])) {
				A[j] = A[i].clone();
				j++;
			}
			i++;
		}
		while (j < i) {
			A[j] = new int[A[0].length];
			j++;
		}
	}

	public boolean isAllMarked(int[] A) {
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				return false;
			}
		}
		return true;
	}

}
