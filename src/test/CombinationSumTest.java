package test;

import java.util.List;

import code.CombinationSum;

public class CombinationSumTest {
	public static void main(String[] args) {
		CombinationSum test = new CombinationSum();
		int[] candidates = { 2, 2, 2, 3, 3, 3 };
		List<List<Integer>> t = test.combinationSum(candidates, 5);
		System.out.println(t.toString());
	}
}
