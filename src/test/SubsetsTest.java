package test;

import code.Subsets;

public class SubsetsTest {
	public static void main(String[] args) {
		Subsets test = new Subsets();
		int[] S = { 1, 2, 3 };

		System.out.println(test.subsetsII(S).toString());
	}
}
