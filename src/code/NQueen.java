package code;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
	public int totalNQueens(int n) {
		return solveNQueens(n).size();
	}

	public List<String[]> solveNQueens(int n) {
		List<String[]> result = new ArrayList<>();
		String[] board = new String[n];
		for (int i = 0; i < board.length; i++) {
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < n; j++) {
				sb.append('0');
			}
			board[i] = sb.toString();
		}
		result.add(board);

		return bfs(result, n);
	}

	public List<String[]> bfs(List<String[]> result, int N) {
		List<List<String[]>> results = new ArrayList<List<String[]>>();
		results.add(result);
		int x = 0;
		while (x < N) {
			List<String[]> newResult = new ArrayList<>();
			for (int n = 0; n < results.get(x).size(); n++) {
				String[] board = results.get(x).get(n);
				for (int i = 0; i < board.length; i++) {
					if (board[x].charAt(i) == '0') {
						String[] temp = board.clone();
						boolean f = placeQueen(temp, i, x, temp.length);
						if (f) {
							newResult.add(temp);
						}
					}
				}
			}
			x++;
			results.add(newResult);
		}
		return results.get(x);
	}

	public boolean placeQueen(String[] board, int col, int row, int n) {
		// column: check is there another queen on this column, set other cell to '.'
		for (int i = 0; i < n; i++) {
			StringBuffer sb = new StringBuffer(board[row]);
			if (i == col) {
				sb.setCharAt(col, 'Q');
				board[row] = sb.toString();
				continue;
			}
			if (board[row].charAt(i) == 'Q') {
				return false;
			}
			sb.setCharAt(i, '.');
			board[row] = sb.toString();
		}
		// row
		for (int i = 0; i < n; i++) {
			StringBuffer sb = new StringBuffer(board[i]);
			if (i == row) {
				sb.setCharAt(col, 'Q');
				board[i] = sb.toString();
				continue;
			}
			if (board[i].charAt(col) == 'Q') {
				return false;
			}
			sb.setCharAt(col, '.');
			board[i] = sb.toString();
		}
		// \
		int i = row, j = col;
		while (true) {
			if (i >= n || j >= n) {
				break;
			}
			StringBuffer sb = new StringBuffer(board[i]);
			if (i == row && j == col) {
				sb.setCharAt(j, 'Q');
				board[i] = sb.toString();
				i++;
				j++;
				continue;
			}
			if (board[i].charAt(j) == 'Q') {
				return false;
			}
			sb.setCharAt(j, '.');
			board[i] = sb.toString();
			i++;
			j++;
		}
		// \
		i = row;
		j = col;
		while (true) {
			if (i < 0 || j < 0) {
				break;
			}
			StringBuffer sb = new StringBuffer(board[i]);
			if (i == row && j == col) {
				sb.setCharAt(j, 'Q');
				board[i] = sb.toString();
				i--;
				j--;
				continue;
			}
			if (board[i].charAt(j) == 'Q') {
				return false;
			}
			sb.setCharAt(j, '.');
			board[i] = sb.toString();
			i--;
			j--;
		}
		// /
		i = row;
		j = col;
		while (true) {
			if (i < 0 || j >= n) {
				break;
			}
			StringBuffer sb = new StringBuffer(board[i]);
			if (i == row && j == col) {
				sb.setCharAt(j, 'Q');
				board[i] = sb.toString();
				i--;
				j++;
				continue;
			}
			if (board[i].charAt(j) == 'Q') {
				return false;
			}
			sb.setCharAt(j, '.');
			board[i] = sb.toString();
			i--;
			j++;
		}
		i = row;
		j = col;
		while (true) {
			if (i >= n || j < 0) {
				break;
			}
			StringBuffer sb = new StringBuffer(board[i]);
			if (i == row && j == col) {
				sb.setCharAt(j, 'Q');
				board[i] = sb.toString();
				i++;
				j--;
				continue;
			}
			if (board[i].charAt(j) == 'Q') {
				return false;
			}
			sb.setCharAt(j, '.');
			board[i] = sb.toString();
			i++;
			j--;
		}
		return true;
	}
}
