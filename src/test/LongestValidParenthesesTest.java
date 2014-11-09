package test;

import code.LongestValidParentheses;

public class LongestValidParenthesesTest {
	public static void main(String[] args) {
		LongestValidParentheses test = new LongestValidParentheses();
		int x = test.longestValidParenthesesII(")())");
		System.out.println(x);
	}
}
