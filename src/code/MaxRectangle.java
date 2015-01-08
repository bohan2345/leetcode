package code;

import java.util.Stack;

public class MaxRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int[][] A = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++)
            A[0][i] = matrix[0][i] == '1' ? 1 : 0;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                A[i][j] = matrix[i][j] == '1' ? A[i - 1][j] + 1 : 0;
            }
        }
        int area = 0;
        for (int i = 0; i < matrix.length; i++) {
            area = Math.max(area, largestRectangleArea(A[i]));
        }
        return area;
    }
    
    public int largestRectangleArea(int[] height) {
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
    
    public int maximalRectangleII(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int n = matrix[0].length;
        int[] L = new int[n];
        int[] R = new int[n];
        int[] H = new int[n];
        int area = 0;
        for (int i = 0; i < n; i++) 
            R[i] = n - 1;
        for (int i = 0; i < matrix.length; i++) {
            int left = 0, right = n - 1;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    L[j] = Math.max(L[j], left);
                    H[j] += 1;
                } else {
                    left = j + 1;
                    H[j] = 0;
                    L[j] = 0;
                    R[j] = n - 1;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    R[j] = Math.min(R[j], right);
                    area = Math.max(area, (R[j] - L[j] + 1) * H[j]);
                } else {
                    right = j - 1;
                }
            }
        }
        return area;
	}
}
