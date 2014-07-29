package test;

import code.SearchRotatedArray;

public class SearchRotatedArrayTest {
	public static void main(String[] args) {
		SearchRotatedArray test = new SearchRotatedArray();
		int[] A = { 8, 1, 2, 3, 4, 5, 6, 7 };
		int[] B = { 2, 2, 2, 0, 2, 2 };
		int r = test.search(B, 0);
		System.out.println(r);
	}
}
