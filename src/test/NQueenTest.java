package test;

import java.util.List;

import code.NQueen;

public class NQueenTest {
	public static void main(String[] args) {
		NQueen test = new NQueen();
		// String[] board = { "0000", "0000", "0000", "0000" };
		// test.placeQueen(board, 1, 2, 4);
		// for (int i = 0; i < board.length; i++) {
		// System.out.println(board[i]);
		// }

		List<String[]> s = test.solveNQueens(4);
		for (int i = 0; i < s.size(); i++) {
			String[] ss = s.get(i);
			for (int j = 0; j < ss.length; j++)
				System.out.println(ss[j]);
		}

		// List<String[]> L = new ArrayList<>();
		// String[] board1 = { "Q...", "....", "....", "...." };
		// String[] board2 = { "....", "Q...", "....", "...." };
		// String[] board3 = { "....", "....", "Q...", "...." };
		// String[] board4 = { "....", "....", "....", "...." };
		// L.add(board1);
		// L.add(board2);
		// L.add(board3);
		// boolean x = test.listContains(L, board4);
		// System.out.println(x);

		System.out.println(test.totalNQueens(4));
	}
}
