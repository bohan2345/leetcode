package test;

import java.util.List;

import code.ThreeSum;

public class ThreeSumTest {
	public static void main(String[] args) {
		ThreeSum test = new ThreeSum();
		int[] num = { -4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6 };
		List<List<Integer>> results = test.threeSum(num);
		System.out.println(results.toString());
	}
}
