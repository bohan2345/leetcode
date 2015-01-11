package test;

import code.WildcardMatching;

public class WildcardMatchingTest {
	public static void main(String[] args) {
		String s = "aa";
		String p = "?***";
		boolean x  = new WildcardMatching().isMatchII(s, p);
		System.out.println(x);
	}
}
