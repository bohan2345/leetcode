package code;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegion {
	public void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}
		int length = board[0].length - 1;
		int height = board.length - 1;
		for (int i = 0; i < length; i++) {
			fill(board, 0, i);
			fill(board, height, length - i);
		}
		for (int j = 0; j < height; j++) {
			fill(board, j, length);
			fill(board, height - j, 0);
		}

		for (int i = 0; i <= height; i++) {
			for (int j = 0; j <= length; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == 'D') {
					board[i][j] = 'O';
				}
			}
		}
	}

	void fill(char[][] board, int x, int y) {
		if (board[x][y] == 'X') {
			return;
		}
		Queue<int[]> Q = new LinkedList<>();
		int[] pair = { x, y };
		Q.offer(pair);
		while (!Q.isEmpty()) {
			int[] p = Q.poll();
			if (board[p[0]][p[1]] == 'O') {
				board[p[0]][p[1]] = 'D';
				if (p[0] - 1 >= 0) {
					int[] top = { p[0] - 1, p[1] };
					Q.offer(top);
				}
				if (p[1] + 1 < board[0].length) {
					int[] right = { p[0], p[1] + 1 };
					Q.offer(right);
				}
				if (p[0] + 1 < board.length) {
					int[] bottom = { p[0] + 1, p[1] };
					Q.offer(bottom);
				}
				if (p[1] - 1 >= 0) {
					int[] left = { p[0], p[1] - 1 };
					Q.offer(left);
				}
			}
		}
	}
}
