package test;

import code.ScrambleString;

public class ScrambleStringTest {
	public static void main(String[] args) {
		ScrambleString test = new ScrambleString();
		System.out.println(test.isScramble("cacbcccbcbaccbabbc", "ccbbbcbbbacaaccccc"));
	}
}
