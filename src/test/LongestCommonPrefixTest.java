package test;

import code.LongestCommonPrefix;

public class LongestCommonPrefixTest {
	public static void main(String[] args) {
		LongestCommonPrefix t = new LongestCommonPrefix();
		String[] strs = { "aa", "a" };
		String s = t.longestCommonPrefix(strs);
		System.out.println(s);
	}
}
