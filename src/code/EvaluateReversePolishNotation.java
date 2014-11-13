package code;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> S = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			String s = tokens[i];
			if (s.equals("+")) {
				S.push(S.pop() + S.pop());
			} else if (s.equals("-")) {
				int a = S.pop();
				int b = S.pop();
				S.push(b - a);
			} else if (s.equals("*")) {
				S.push(S.pop() * S.pop());
			} else if (s.equals("/")) {
				int a = S.pop();
				int b = S.pop();
				S.push(b / a);
			} else {
				S.push(Integer.valueOf(s));
			}
		}
		return S.pop();
	}
}
