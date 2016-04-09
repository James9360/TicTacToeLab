package edu.cis232.tictactoe;

public class Board {
	String[][] board = new String[3][3];

	public static void main(String[] args) {
		// Simple tests.

		// X Row
		String[][] board = { { "X", "X", "X" }, { "O", null, "O" }, { "X", "O", "O" } };

		System.out.println("Winner (X) =" + Board.checkWin(board));
		System.out.println("Tie game false =" + Board.isTie(board));

		// O diagonal
		String[][] board1 = { { "O", "X", "X" }, { "O", "O", "O" }, { "X", "O", "O" } };

		System.out.println("Winner (O) =" + Board.checkWin(board1));

		// X Column
		String[][] board2 = { { "O", "X", "X" }, { "O", "O", "X" }, { "X", "O", "X" } };

		System.out.println("Winner (X) =" + Board.checkWin(board2));

		// Cat's Game
		String[][] board3 = { { "O", "X", "O" }, { "O", "O", "X" }, { "X", "O", "X" } };

		System.out.println("Winner null =" + Board.checkWin(board3));
		System.out.println("Tie game true =" + Board.isTie(board3));

		// New game
		String[][] board4 = new String[3][3];
		System.out.println("Winner null =" + Board.checkWin(board4));
		System.out.println("Tie game false =" + Board.isTie(board4));
	}

	/**
	 * Determines a winner by checking rows and columns and diagonals.
	 * 
	 * @return the winning player (X or 0). Returns null if there is no winner
	 */
	public String checkWin() {
		return Board.checkWin(board);
	}

	/**
	 * Determines a tie by checking if all of the places have filled and their
	 * is no winner.
	 * 
	 * @return true if game ended in a tie. false otherwise.
	 */
	public boolean isTie() {
		return Board.isTie(board);
	}

	private static boolean isTie(String[][] board) {
		for (String[] row : board) {
			for (String val : row) {
				if (val == null) {
					// Empty slot, it can't be a tie
					return false;
				}
			}
		}
		
		//Only a tie if it there is no winner
		return checkWin(board) == null;
	}

	private static String checkWin(String[][] board) {
		String winner = null;
		// Check rows
		winner = checkRowWinner(board);
		// Check columns
		if (winner == null) {
			winner = checkColWinner(board);
		}

		if (winner == null) {
			winner = checkDiagonalWinner(board);
		}

		return winner;
	}

	private static String checkRowWinner(String[][] board) {
		String winner = null;
		for (int row = 0; row < board.length; row++) {
			boolean hasNull = false;
			for (int col = 0; col < board[row].length; col++) {
				// Check if there is a null first
				if (board[row][col] == null) {
					hasNull = true;
				}
			}

			boolean hasDifferent = false;
			String player = board[row][0];
			if (!hasNull) {
				// Check if winner
				for (int col = 1; col < board[row].length; col++) {
					if (!player.equals(board[row][col])) {
						hasDifferent = true;
					}
				}
			}

			if (!hasNull && !hasDifferent) {
				winner = player;
			}
		}

		return winner;
	}

	private static String checkColWinner(String[][] board) {
		String winner = null;

		for (int col = 0; col < board[0].length; col++) {
			boolean hasNull = false;
			for (int row = 0; row < board.length; row++) {
				// Check if there is a null first
				if (board[row][col] == null) {
					hasNull = true;
				}
			}

			boolean hasDifferent = false;
			String player = board[0][col];
			if (!hasNull) {
				// Check if winner
				for (int row = 1; row < board.length; row++) {
					if (!player.equals(board[row][col])) {
						hasDifferent = true;
					}
				}
			}

			if (!hasNull && !hasDifferent) {
				winner = player;
			}
		}

		return winner;
	}

	private static String checkDiagonalWinner(String[][] board) {
		// Check top-left to bottom-right
		if (board[0][0] != null && board[1][1] != null && board[2][2] != null) {
			if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
				return board[0][0];
			}
		}

		// Check bottom-left to top-right
		if (board[2][0] != null && board[1][1] != null && board[0][2] != null) {
			if (board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2])) {
				return board[1][1];
			}
		}

		return null;
	}

}
