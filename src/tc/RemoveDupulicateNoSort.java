package tc;


public class RemoveDupulicateNoSort {
	public int removeDupulicate(int[] C) {
		if (C.length < 2) {
			return C.length;
		}
		int end = C.length - 1;
		for (int i = 0; i < C.length - 1; i++) {
			for (int j = i + 1; j <= end; j++) {
				if (C[i] == C[j]) {
					C[j] = C[end];
					C[end] = 0;
					end--;
					j--;
				}
			}
		}
		return end + 1;
	}

	public static void main(String[] args) {
		RemoveDupulicateNoSort test = new RemoveDupulicateNoSort();
		// int[] C = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int[] C = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3 };
		int e = test.removeDupulicate(C);
		for (int i = 0; i < e; i++)
			System.out.println(C[i]);
	}
}
