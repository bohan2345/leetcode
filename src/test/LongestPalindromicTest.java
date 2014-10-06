package test;

import code.LongestPalindromic;

public class LongestPalindromicTest {
	public static void main(String[] args) {
		LongestPalindromic test = new LongestPalindromic();
		String s = "abcba";
		String ss = test.longestPalindrome(s);
		System.out.println(ss);
	}
}
