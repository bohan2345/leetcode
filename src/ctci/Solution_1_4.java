package ctci;

public class Solution_1_4 {
	public static void replace(char[] A, int length) {
		int l = length;
		for (int i = 0; i < length; i++) {
			if (A[i] == ' ') {
				l += 2;
			}
		}
		A[l] = '\0';
		l--;
		for (int i = length - 1; i >= 0; i--) {
			if (A[i] == ' ') {
				A[l] = '0';
				A[l - 1] = '2';
				A[l - 2] = '%';
				l = l - 3;
			} else {
				A[l] = A[i];
				l--;
			}
		}
	}

	public static void main(String[] args) {
		char[] A = new char[100];
		A[0] = 'a';
		A[1] = 'b';
		A[2] = ' ';
		A[3] = 'c';
		A[4] = ' ';
		A[5] = 'd';
		A[6] = ' ';
		replace(A, 7);
		String c = new String(A);
		System.out.print(c);
	}
}
