package test;

import java.util.List;

import code.CombinationSumII;

public class CombinationSumTest {
	public static void main(String[] args) {
		CombinationSumII test = new CombinationSumII();
		int[] candidates = { 3,1,3,5,1,1};
		List<List<Integer>> t = test.combinationSum2(candidates, 8);
		System.out.println(t.toString());
	}
}
