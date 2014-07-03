package test;

import code.RemoveElement;

public class RemoveElementTest {
	public static void main(String[] args) {
		int[] A = { 2, 2, 3 };
		int elem = 2;
		RemoveElement test = new RemoveElement();
		int x = test.removeElement(A, elem);
		System.out.println(x);
		for (int i = 0; i < A.length; i++)
			System.out.print(A[i]);
	}
}
