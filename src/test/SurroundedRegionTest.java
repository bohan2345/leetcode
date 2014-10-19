package test;

import code.SurroundedRegion;

public class SurroundedRegionTest {
	public static void main(String[] args) {
		SurroundedRegion test = new SurroundedRegion();
		char[][] board = { { 'O', 'O', 'O' }, { 'O', 'O', 'O' }, { 'O', 'O', 'O' } };
		test.solve(board);
		System.out.println(board);
	}
}
