package test;

import java.util.List;

import code.ThreeSum;

public class ThreeSumTest {
	public static void main(String[] args) {
		ThreeSum test = new ThreeSum();
		int[] num = { 1, 1, 1 };
		List<List<Integer>> results = test.threeSum(num);
		System.out.println(results.size());
	}
}
