package test;

import java.util.List;

import code.LongestCommonSubstring;

public class LongestCommonSubstringTest {
	public static void main(String[] args) {
		LongestCommonSubstring test = new LongestCommonSubstring();
		String A = "ABAB";
		String B = "BABA";
		List<String> s = test.findLongestSubstring(A, B);
		for (int i = 0; i < s.size(); i++) {
			System.out.println(s.get(i));
		}
	}
}
