package code;

import java.util.Stack;

public class LongestValidParentheses {
	/*
	 * Dynamic Programming : f(i) denote the longestValidParentheses exactly at index i if s.charAt(i) == '(' then the s.substring(0, i + 1) won't be a valid parentheses so f(i) = 0 if s.charAt(i) ==
	 * ')' then it might be if s.charAt(i - 1) == '(' then f(i) = f(i - 2) + 2 if s.charAt(i - 1) == ')' then we need to check f(i - f(i - 1) - 2)
	 */
	public int longestValidParentheses(String s) {
		if (s == null || s.length() < 2)
			return 0;
		int[] A = new int[s.length() + 1];
		A[0] = 0;
		A[1] = 0;
		int max = 0;
		for (int i = 2; i <= s.length(); i++) {
			if (s.charAt(i - 1) == '(')
				A[i] = 0;
			else {
				if (s.charAt(i - 2) == '(') {
					A[i] = A[i - 2] + 2;
				}
				else if (i - A[i - 1] - 2 >= 0 && s.charAt(i - A[i - 1] - 2) == '(') {
					A[i] = A[i - 1] + 2;
					if (A[i - A[i - 1] - 2] > 0)
						A[i] += A[i - A[i - 1] - 2];
				}
				else
					A[i] = 0;
			}
			max = Math.max(max, A[i]);
		}
		return max;
	}

	public int longestValidParenthesesII(String s) {
        if (s == null || s.length() < 2)
            return 0;
        Stack<Integer> S = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!S.isEmpty() && s.charAt(i) == ')' && s.charAt(S.peek()) == '(')
                S.pop();
            else 
            	S.push(i);
        }
        int i = s.length(), j = 0, max = 0; 
        while (!S.isEmpty()) {
            j = i;
            i = S.pop();
            max = Math.max(j - i - 1, max);
        }
        return Math.max(i, max);
    }
}
