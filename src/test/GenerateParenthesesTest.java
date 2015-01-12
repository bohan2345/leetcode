package test;

import java.util.List;

import code.GenerateParentheses;

public class GenerateParenthesesTest {
	public static void main(String[] args) {
		GenerateParentheses test = new GenerateParentheses();
		List<String> s = test.generateParenthesis(3);
		System.out.println(s.toString());
	}
}
