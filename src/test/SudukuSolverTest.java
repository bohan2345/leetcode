package test;

import code.SudokuSolver;

public class SudukuSolverTest {
	public static void main(String[] args) {
		SudokuSolver test = new SudokuSolver();
		char[][] board = { new String("53..7....").toCharArray(), 
						   new String("6..195...").toCharArray(), 
						   new String(".98....6.").toCharArray(), 
						   new String("8...6...3").toCharArray(),
						   new String("4..8.3..1").toCharArray(), 
						   new String("7...2...6").toCharArray(), 
						   new String(".6....28.").toCharArray(), 
						   new String("...419..5").toCharArray(),
						   new String("....8..79").toCharArray() };
		test.solveSudoku(board);
		for (char[] c : board) {
			for (int i = 0; i < 9; i++)
				System.out.print(c[i]);
			System.out.println("");
		}
	}
}
