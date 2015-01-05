package code;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0)
			return false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (word.charAt(0) == board[i][j] && search(i, j, board, word, 0, new boolean[board.length][board[0].length])) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean search(int x, int y, char[][] board, String word, int i, boolean[][] visited) {
		if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited[x][y])
			return false;
		if (i == word.length() - 1) {
			if (board[x][y] == word.charAt(i))
				return true;
			else
				return false;
		}
		if (board[x][y] != word.charAt(i))
			return false;
		visited[x][y] = true;
		boolean top = search(x - 1, y, board, word, i + 1, visited);
		if (top) {
			return true;
		}
		boolean right = search(x, y + 1, board, word, i + 1, visited);
		if (right) {
			return true;
		}
		boolean bot = search(x + 1, y, board, word, i + 1, visited);
		if (bot) {
			return true;
		}
		boolean left = search(x, y - 1, board, word, i + 1, visited);
		visited[x][y] = false;
		return left;
	}

	public boolean existII(char[][] board, String word) {
		if (board == null || board.length == 0 || word.length() > board.length * board[0].length)
			return false;
		char c = word.charAt(0);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (c == board[i][j]) {
					boolean[][] visited = new boolean[board.length][board[0].length];
					if (exist(board, word, 0, visited, i, j))
						return true;
				}
			}
		}
		return false;
	}

	boolean exist(char[][] board, String word, int s, boolean[][] visited, int i, int j) {
		if (s == word.length() - 1 && board[i][j] == word.charAt(s))
			return true;
		if (board[i][j] != word.charAt(s))
			return false;
		visited[i][j] = true;
		boolean a = false, b = false, c = false, d = false;
		if (i + 1 < board.length && !visited[i + 1][j]) {
			a = exist(board, word, s + 1, visited, i + 1, j);
			if (a) {
				return true;
			}
		}
		if (j + 1 < board[0].length && !visited[i][j + 1]) {
			b = exist(board, word, s + 1, visited, i, j + 1);
			if (b) {
				return true;
			}
		}
		if (i - 1 >= 0 && !visited[i - 1][j]) {
			c = exist(board, word, s + 1, visited, i - 1, j);
			if (c) {
				return true;
			}
		}
		if (j - 1 >= 0 && !visited[i][j - 1])
			d = exist(board, word, s + 1, visited, i, j - 1);
		visited[i][j] = false;
		return d;
	}
}
