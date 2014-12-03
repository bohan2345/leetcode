package test;

import code.SudokuSolver;

public class SudukuSolverTest {
	public static void main(String[] args) {
		SudokuSolver test = new SudokuSolver();
		char[][] board = { new String("591..8...").toCharArray(), 
						   new String("........2").toCharArray(), 
						   new String("..2..3..6").toCharArray(), 
						   new String("....9.5.7").toCharArray(),
						   new String("47..8..91").toCharArray(), 
						   new String("9.6.1....").toCharArray(), 
						   new String("3..4..7..").toCharArray(), 
						   new String("1........").toCharArray(),
						   new String("...5..143").toCharArray() };
		test.solveSudoku(board);
		for (char[] c : board) {
			for (int i = 0; i < 9; i++)
				System.out.print(c[i]);
			System.out.println("");
		}
	}
}
