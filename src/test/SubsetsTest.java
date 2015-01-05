package test;

import code.Subsets;
import code.SubsetsWithDup;

public class SubsetsTest {
	public static void main(String[] args) {
//		Subsets test = new Subsets();
		int[] S = { 2, 2, 2 };

		System.out.println(new SubsetsWithDup().subsetsWithDupII(S));
		System.out.println(new SubsetsWithDup().subsetsWithDup(S));
	}
}
