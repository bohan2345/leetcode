package test;

import code.NQueen;

public class NQueenTest {
	public static void main(String[] args) {
		NQueen test = new NQueen();
		char[][] board = new char[4][4];
		test.placeQueen(board, 1, 2, 4);
		System.out.println(board);
	}
}
