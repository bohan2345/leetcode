package code;

public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		solve(board, 0, 0);
	}

	private boolean solve(char[][] board, int row, int col) {
		if (col > 8) {
			row++;
			col = 0;
		}
		if (row > 8) {
			return true;
		}
		if (board[row][col] == '.') {
			for (int x = 1; x < 10; x++) {
				if (isValid(board, (char) (x + '0'), row, col)) {
					board[row][col] = (char) (x + '0');
					if (solve(board, row, col + 1))
						return true;
					board[row][col] = '.';
				}
			}
			return false;
		} else
			return solve(board, row, col + 1);
	}

	private boolean isValid(char[][] board, char c, int row, int col) {
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == c)
				return false;
			if (board[i][col] == c)
				return false;
		}
		int left = (col / 3) * 3;
		int top = (row / 3) * 3;
		for (int i = left; i < left + 3; i++) {
			for (int j = top; j < top + 3; j++) {
				if (board[j][i] == c)
					return false;
			}
		}
		return true;
	}
}
