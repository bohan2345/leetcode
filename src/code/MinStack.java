package code;

import java.util.Stack;

public class MinStack {
	private Stack<Integer> S = new Stack<>();
	private Stack<Integer> min = new Stack<>();

	public void push(int x) {
		S.push(x);
		if (min.isEmpty() || min.peek() > x)
			min.push(x);
	}

	public void pop() {
		int x = S.pop();
		if (S.isEmpty() || (x == min.peek() && x != S.peek()))
			min.pop();
	}

	public int top() {
		return S.peek();
	}

	public int getMin() {
		return min.peek();
	}
}
