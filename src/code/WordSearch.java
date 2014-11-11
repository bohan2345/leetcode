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
			visited[x][y] = false;
			return true;
		}
		boolean right = search(x, y + 1, board, word, i + 1, visited);
		if (right) {
			visited[x][y] = false;
			return true;
		}
		boolean bot = search(x + 1, y, board, word, i + 1, visited);
		if (bot) {
			visited[x][y] = false;
			return true;
		}
		boolean left = search(x, y - 1, board, word, i + 1, visited);
		visited[x][y] = false;
		return top || right || bot || left;
	}
}
