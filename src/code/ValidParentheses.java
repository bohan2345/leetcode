package code;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		if (s == null || s.length() == 0)
			return false;
		if (s.length() % 2 == 1) {
			return false;
		}
		Map<Character, Character> table = new HashMap<>();
		table.put(')', '(');
		table.put(']', '[');
		table.put('}', '{');
		Stack<Character> S = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (S.isEmpty() || table.get(c) != S.peek())
				S.push(c);
			else
				S.pop();
		}
		return S.isEmpty();
	}
}
