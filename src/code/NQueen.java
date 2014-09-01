package code;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
	public int totalNQueens(int n) {
		return 0;
	}

	public List<String[]> solveNQueens(int n) {
		List<String[]> result = new ArrayList<>();
		char[][] board = new char[n][n];
		boolean f = true;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				if (board[row][col] != '.' && board[row][col] != 'Q') {
					f = placeQueen(board, col, row, n);
					if (f == false) {
						break;
					}
				}
			}
		}
		return result;
	}
	
	public void dfs(List<String[]> result, char[][] board, char[][] visited){
		
	}

	public boolean placeQueen(char[][] board, int col, int row, int n) {
		// column: check is there another queen on this column, set other cell to '.'
		for (int i = 0; i < n; i++) {
			if (i == col) {
				board[row][col] = 'Q';
				continue;
			}
			if (board[row][i] == 'Q') {
				return false;
			}
			board[row][i] = '.';
		}
		// row
		for (int i = 0; i < n; i++) {
			if (i == row) {
				board[row][col] = 'Q';
				continue;
			}
			if (board[i][col] == 'Q') {
				return false;
			}
			board[i][col] = '.';
		}
		// \
		int i = col, j = row;
		while (true) {
			if (i >= n || j >= n) {
				break;
			}
			if (i == col && j == row) {
				board[row][col] = 'Q';
				i++;
				j++;
				continue;
			}
			if (board[j][i] == 'Q') {
				return false;
			}
			board[j][i] = '.';
			i++;
			j++;
		}
		// \
		i = col;
		j = row;
		while (true) {
			if (i < 0 || j < 0) {
				break;
			}
			if (i == col && j == row) {
				board[row][col] = 'Q';
				i--;
				j--;
				continue;
			}
			if (board[j][i] == 'Q') {
				return false;
			}
			board[j][i] = '.';
			i--;
			j--;
		}
		// /
		i = col;
		j = row;
		while (true) {
			if (i < 0 || j >= n) {
				break;
			}
			if (i == col && j == row) {
				board[row][col] = 'Q';
				i--;
				j++;
				continue;
			}
			if (board[j][i] == 'Q') {
				return false;
			}
			board[j][i] = '.';
			i--;
			j++;
		}
		i = col;
		j = row;
		while (true) {
			if (i >= n || j < 0) {
				break;
			}
			if (i == col && j == row) {
				board[row][col] = 'Q';
				i++;
				j--;
				continue;
			}
			if (board[j][i] == 'Q') {
				return false;
			}
			board[j][i] = '.';
			i++;
			j--;
		}
		return true;
	}
}
