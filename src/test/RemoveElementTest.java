package test;

import code.RemoveElement;

public class RemoveElementTest {
	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4 };
		int[] B = { 1, 2, 3, 4 };
		int elem = 1;
		RemoveElement test = new RemoveElement();
		int x = test.removeElement(A, elem);
		int y = test.removeElementII(B, elem);
		System.out.println(x);
		for (int i = 0; i < A.length; i++)
			System.out.print(A[i]);

		System.out.println("\n---------------------------------");

		System.out.println(y);
		for (int i = 0; i < B.length; i++)
			System.out.print(B[i]);
	}
}
