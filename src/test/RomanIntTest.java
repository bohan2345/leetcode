package test;

import code.RomanInt;

public class RomanIntTest {
	public static void main(String[] args) {
		RomanInt test = new RomanInt();
		int n = 100;
		String r = test.intToRoman(n);
		System.out.print(r);
	}
}
