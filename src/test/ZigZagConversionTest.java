package test;

import code.ZigZagConversion;

public class ZigZagConversionTest {
	public static void main(String[] args) {
		ZigZagConversion test = new ZigZagConversion();
		String s = test.convert("ABC", 2);
		System.out.println(s);
	}
}
