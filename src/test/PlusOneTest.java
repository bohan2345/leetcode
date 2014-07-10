package test;

import code.PlusOne;

public class PlusOneTest {
	public static void main(String[] args) {
		PlusOne test = new PlusOne();
		int[] digits = { 1, 2 };
		digits = test.plusOne(digits);
		for (int i = 0; i < digits.length; i++) {
			System.out.print(digits[i]);
		}
	}
}
