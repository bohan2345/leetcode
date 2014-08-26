package code;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		if ((board == null) || (board.length % 3 != 0) || (board.length != board[0].length))
			return false;
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board.length; x++) {
				if (board[y][x] == '.') {
					continue;
				}
				if (isValidInRow(x, y, board) && isValidInColumn(x, y, board) && isValidInRegion(x, y, board)) {
					continue;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isValidInRow(int x, int y, char[][] board) {
		for (int i = x + 1; i < board.length; i++) {
			if (board[y][i] == '.') {
				continue;
			}
			if (board[y][x] == board[y][i]) {
				return false;
			}
		}
		return true;
	}

	public boolean isValidInColumn(int x, int y, char[][] board) {
		for (int i = y + 1; i < board.length; i++) {
			if (board[i][x] == '.') {
				continue;
			}
			if (board[y][x] == board[i][x]) {
				return false;
			}
		}
		return true;
	}

	public boolean isValidInRegion(int x, int y, char[][] board) {
		int a = (x / 3) * 3;
		int b = (y / 3) * 3;
		for (int i = b; i < b + 3; i++) {
			for (int j = a; j < a + 3; j++) {
				if (j == x && i == y) {
					continue;
				}
				if (board[i][j] == '.') {
					continue;
				}
				if (board[y][x] == board[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
