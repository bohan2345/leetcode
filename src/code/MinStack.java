package code;

import java.util.Stack;

public class MinStack {
	Stack<Integer> S = new Stack<>();
    Stack<Integer> min = new Stack<>();
    
    public void push(int x) {
        S.push(x);
        if (min.isEmpty() || x <= min.peek())
            min.push(x);
    }

    public void pop() {
        int x = S.pop();
        if (!min.isEmpty() && x == min.peek())
            min.pop();
    }

    public int top() {
        return S.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
