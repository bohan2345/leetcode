package tc;

public class MS {
	public static void main(String[] args) {
		int[][] A = { { 0, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } };
		MS test = new MS();
		test.removeAllMarked(A);
		System.out.println(A);
	}

	public void removeAllMarked(int[][] A) {
		int row = 0;
		int above = 1;
		while (above < A.length && row < A.length) {
			if (isAllMarked(A[row])) {
				int i = row;
				int j = above;
				while (i < A.length) {
					if (j > A.length - 1) {
						int[] tmp = { 0, 0, 0, 0 };
						A[i] = tmp;
					} else {
						A[i] = A[j].clone();
					}
					i++;
					j++;
				}
			} else {
				row++;
				above++;
			}
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
