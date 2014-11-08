package code;

import java.util.Stack;

public class LargestRectangleHistogram {
	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		Stack<Integer> S = new Stack<>();
		int max = 0;
		int j = 0;
		for (int i = 0; i <= height.length; i++) {
			int h = i < height.length ? height[i] : 0;
			if (S.isEmpty() || h >= height[S.peek()]) {
				S.push(i);
			} else {
				while (!S.isEmpty() && h < height[S.peek()]) {
					j = S.pop();
					if (S.isEmpty()) {
						max = Math.max(max, i * height[j]);
					} else {
						max = Math.max((i - S.peek() - 1) * height[j], max);
					}
				}
				S.push(i);
			}
		}
		return max;
	}

	public int largestRectangleAreaII(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		int area = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i <= height.length; i++) {
			int h = i < height.length ? height[i] : 0;
			if (stack.empty() || height[stack.peek()] < h) {
				stack.push(i);
			} else {
				int start = stack.pop();
				int width = stack.empty() ? i : i - stack.peek() - 1;
				area = Math.max(area, height[start] * width);
				i--;
			}
		}
		return area;
	}
}
