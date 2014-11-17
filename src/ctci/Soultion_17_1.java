package ctci;

public class Soultion_17_1 {
	public static void swap(int[] A, int i, int j) {
		A[i] += A[j];
		A[j] = A[i] - A[j];
		A[i] = A[i] - A[j];
	}

	public static void main(String[] args) {
		int[] A = { 999, 5 };
		swap(A, 0, 1);
		System.out.println(A[0] + ", " + A[1]);
	}
}
