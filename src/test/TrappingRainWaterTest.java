package test;

import code.TrappingRainWater;

public class TrappingRainWaterTest {
	public static void main(String[] args) {
		TrappingRainWater test = new TrappingRainWater();
		int[] A = { 4, 2, 0, 3, 2, 5 };
		int sum = test.trap(A);
		System.out.println(sum);
	}
}
