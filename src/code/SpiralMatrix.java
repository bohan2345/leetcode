package code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> results = new ArrayList<>();
		if (matrix == null || matrix.length == 0)
			return results;
		int m = matrix.length;
		int n = matrix[0].length;
		for (int level = 0; level < (Math.min(m, n) + 1) / 2; level++) {
			Queue<Integer> top = new LinkedList<>();
			Queue<Integer> right = new LinkedList<>();
			Queue<Integer> bot = new LinkedList<>();
			Queue<Integer> left = new LinkedList<>();
			for (int i = level; i < n - level - 1; i++) {
				top.offer(matrix[level][i]);
				bot.offer(matrix[m - level - 1][n - i - 1]);
			}
			for (int i = level; i < m - level - 1; i++) {
				right.offer(matrix[i][n - level - 1]);
				left.offer(matrix[m - i - 1][level]);
			}
			if (level == n - level - 1) {
				right.clear();
				left.clear();
				for (int i = level; i < m - level; i++)
					right.offer(matrix[i][n - level - 1]);
			}
			if (level == m - level - 1) {
				top.clear();
				bot.clear();
				right.clear();
				left.clear();
				for (int i = level; i < n - level; i++)
					top.offer(matrix[level][i]);
			}
			while (!top.isEmpty()) {
				results.add(top.poll());
			}
			while (!right.isEmpty()) {
				results.add(right.poll());
			}
			while (!bot.isEmpty()) {
				results.add(bot.poll());
			}
			while (!left.isEmpty()) {
				results.add(left.poll());
			}
		}
		return results;
	}

	public List<Integer> spiralOrderII(int[][] matrix) {
		List<Integer> results = new ArrayList<>();
		if (matrix == null || matrix.length == 0)
			return results;
		int direction = 0; // 0 go right, 1 go down, 2 go left, 3 go up
		int m = matrix.length;
		int n = matrix[0].length;
		int i = 0;
		int j = 0;
		while (true) {
			if (direction == 0) {
				results.add(matrix[i][j]);
				j++;
				if (j == n - i - 1)
					direction = 1;
				else if (j > n - i - 1) { // if there is only one column, this is the only special case
					direction = 1;
					j--;
					i++;
				}

			}
			else if (direction == 1) {
				results.add(matrix[i][j]);
				i++;
				if (i == m + j - n)
					direction = 2;
			}
			else if (direction == 2) {
				results.add(matrix[i][j]);
				j--;
				if (j == m - i - 1)
					direction = 3;
			}
			else if (direction == 3) {
				results.add(matrix[i][j]);
				i--;
				if (i == j + 1)
					direction = 0;
			}
			if (results.size() == m * n)
				break;
		}
		return results;
	}
}
