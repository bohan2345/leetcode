package test;

import code.RemoveElement;

public class RemoveElementTest {
	public static void main(String[] args) {
		int[] A = { 1 };
		int elem = 1;
		int x = (new RemoveElement()).removeElement(A, elem);
		System.out.println(x);
		for (int i = 0; i < A.length; i++)
			System.out.print(A[i]);

	}
}
