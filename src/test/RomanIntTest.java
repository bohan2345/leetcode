package test;

import code.RomanInt;

public class RomanIntTest {
	public static void main(String[] args) {
		RomanInt test = new RomanInt();
		String s = "X";
		int n = 100;
		int num = test.romanToInt(s);
		String r = test.intToRoman(n);
		System.out.print(r);
	}
}
