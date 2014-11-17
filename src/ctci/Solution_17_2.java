package ctci;

public class Solution_17_2 {
	/*
	 * there are 3^9 possible cases, we can put all cases in an Array or HashMap, 
	 * which will give us O(1) time complexity. if We are going to call this function many many times.
	 */
	
	public int checkWinner (char[][] board) {
		//board[0][0] == board[1][1] == board[2][2] == 'O' or 'X'
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			return board[1][1] == 'O' ? 1 : 2;
		}
		//board[2][0] == board[1][1] == board[0][2] == 'O' or 'X'
		if (board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
			return board[1][1] == 'O' ? 1 : 2;
		}
		// row
		for (int i = 0; i < 3; i++) {

		}
		// col
		for (int i = 0; i < 3; i++) {
			
		}
		return -1;
	}
}
