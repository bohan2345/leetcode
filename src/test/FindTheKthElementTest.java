package test;

import code.FindTheKthElement;

public class FindTheKthElementTest {
	public static void main(String[] args) {
		FindTheKthElement test = new FindTheKthElement();
		int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, };
		int[] x = test.findBig(A, 3);
		for (int i = 0; i < x.length; i++)
			System.out.println(x[i]);
	}
}
