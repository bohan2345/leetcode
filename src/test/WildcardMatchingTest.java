package test;

import code.WildcardMatching;

public class WildcardMatchingTest {
	public static void main(String[] args) {
		String s = "asd";
		String p = "as?";
		boolean x  = new WildcardMatching().isMatch(s, p);
		System.out.println(x);
	}
}
