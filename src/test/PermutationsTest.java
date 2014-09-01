package test;

import java.util.List;

import code.Permutations;

public class PermutationsTest {
	public static void main(String[] args) {
		Permutations test = new Permutations();
		int[] num = { 1, 2, 3 };
		List<List<Integer>> x = test.permuteII(num);
		System.out.println(x.size());
	}
}
