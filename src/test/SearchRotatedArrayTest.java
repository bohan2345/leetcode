package test;

import code.SearchRotatedArray;

public class SearchRotatedArrayTest {
	public static void main(String[] args) {
		SearchRotatedArray test = new SearchRotatedArray();
		int[] A = { 8, 1, 2, 3, 4, 5, 6, 7 };
		int r = test.search(A, 8);
		System.out.println(r);
	}
}
