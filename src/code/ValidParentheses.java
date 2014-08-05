package code;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		if (s == null) {
			return false;
		}
		if (s.length() % 2 == 1) {
			return false;
		}
		Map<Character, Character> pair = new HashMap<>();
		pair.put(')', '(');
		pair.put(']', '[');
		pair.put('}', '{');
		Stack<Character> chars = new Stack<Character>();
		chars.push(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				chars.push(c);
			} else {
				if (pair.get(c) == chars.peek()) {
					chars.pop();
				} else {
					return false;
				}
			}
		}
		if (chars.size() > 0) {
			return false;
		} else {
			return true;
		}
	}
}
