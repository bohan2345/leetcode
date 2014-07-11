package test;

import code.Search2DMatrix;

public class Search2DMatrixTest {
	public static void main(String[] args) {
		Search2DMatrix test = new Search2DMatrix();
		int[] A = { 1,3, 5, 7 };
		int a = test.binarySearch(A, 7,0,3);
		System.out.println(a);
	}
}
