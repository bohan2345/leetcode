package test;

import code.WordSearch;

public class WordSearchTest {
	public static void main(String[] args) {
		WordSearch test = new WordSearch();
		char[][] board = { { 'A', 'B', 'C', 'D', 'E' }, { 'T', 'S', 'R', 'Q', 'F' }, { 'M', 'N', 'O', 'P', 'G' }, { 'L', 'K', 'J', 'I', 'H' } };// {"ABCDE","TSRQF","MNOPG","LKJIH"};
		// char[][] board = { { 'A', 'B' }, { 'C', 'D' } };
		boolean x = test.existII(board, "ABCDEFGHIJKLMNOPQRST");
		System.out.println(x);
	}
}
