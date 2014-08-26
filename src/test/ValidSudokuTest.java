package test;

import code.ValidSudoku;

public class ValidSudokuTest {
	public static void main(String[] args) {
		ValidSudoku test = new ValidSudoku();
		char[][] board = new char[9][9];
		for (int x = 1; x < 9; x++) {
			char c = Integer.toString(9 - x).charAt(0);
			board[0][x] = c;
		}
		for (int y = 1; y < 9; y++) {
			char c = Integer.toString(y + 1).charAt(0);
			board[y][0] = c;
		}
		boolean s = test.isValidSudoku(board);
		//System.out.println(board[0][0] == 0);
		System.out.println(s);
	}

}
