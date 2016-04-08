package edu.cis232;

public class Board
{
	private String[][] board = new String[3][3];
	/**
	 * Determines a winner by checking rows and columns and diagonals.
	 * 
	 * @return the winning player (X or 0). Returns null if there is no winner
	 */
	public String checkWin() 
	{
		return Board.checkWin(board);
	}
	
	/**
	 * Updates the game board.
	 * @param row int-Holds the row number
	 * @param col int-Holds the column number.
	 * @param player Holds a boolean that flips between player 1 and player 2.
	 */
	public void updateBoard(int row, int col, boolean player)
	{
		for (int i=0; i<=row; i++)
		{
			for (int j=0; j<=col; j++)
			{
				if ((col == j) && (row == i) && (player))
				{
					board[i][j] =  "O";
					//System.out.println(i);
					//System.out.println(j);
				}
				else if ((col == j) && (row == i) && (!player))
				{
					board[i][j] =  "X";
					//System.out.println(i);
					//System.out.println(j);
				}
			}
		}
		//This is just to check if the board is formatted correctly in the array.
		System.out.println();
		for (int i=0; i<board.length; i++)
		{
			for (int j=0; j<board[i].length; j++)
			{
				if (board[i][j] != null)
					System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	/**
	 * Deletes the board for a new game.
	 */
	public void deleteBoard()
	{
		board = null;
	}
	
	/**
	 * Returns the board.
	 * @return String[][]
	 */
	public String[][] getBoard()
	{
		return board;
	}

	/**
	 * Determines a tie by checking if all of the places have filled and their
	 * is no winner.
	 * 
	 * @return true if game ended in a tie. false otherwise.
	 */
	public boolean isTie() 
	{
		return Board.isTie(board);
	}

	private static boolean isTie(String[][] board) 
	{
		for (String[] row : board) 
		{
			for (String val : row) 
			{
				if (val == null) 
				{
					// Empty slot, it can't be a tie
					return false;
				}
			}
		}
		
		//Only a tie if it there is no winner
		return checkWin(board) == null;
	}

	private static String checkWin(String[][] board) 
	{
		String winner = null;
		// Check rows
		winner = checkRowWinner(board);
		// Check columns
		if (winner == null) 
		{
			winner = checkColWinner(board);
		}

		if (winner == null) 
		{
			winner = checkDiagonalWinner(board);
		}

		return winner;
	}

	private static String checkRowWinner(String[][] board) 
	{
		String winner = null;
		for (int row = 0; row < board.length; row++) 
		{
			boolean hasNull = false;
			for (int col = 0; col < board[row].length; col++) 
			{
				// Check if there is a null first
				if (board[row][col] == null) 
				{
					hasNull = true;
				}
			}

			boolean hasDifferent = false;
			String player = board[row][0];
			if (!hasNull) {
				// Check if winner
				for (int col = 1; col < board[row].length; col++) 
				{
					if (!player.equals(board[row][col])) 
					{
						hasDifferent = true;
					}
				}
			}

			if (!hasNull && !hasDifferent) 
			{
				winner = player;
			}
		}

		return winner;
	}

	private static String checkColWinner(String[][] board) 
	{
		String winner = null;

		for (int col = 0; col < board[0].length; col++) 
		{
			boolean hasNull = false;
			for (int row = 0; row < board.length; row++) 
			{
				// Check if there is a null first
				if (board[row][col] == null) 
				{
					hasNull = true;
				}
			}

			boolean hasDifferent = false;
			String player = board[0][col];
			if (!hasNull) 
			{
				// Check if winner
				for (int row = 1; row < board.length; row++) 
				{
					if (!player.equals(board[row][col])) 
					{
						hasDifferent = true;
					}
				}
			}

			if (!hasNull && !hasDifferent) 
			{
				winner = player;
			}
		}

		return winner;
	}

	private static String checkDiagonalWinner(String[][] board) 
	{
		// Check top-left to bottom-right
		if (board[0][0] != null && board[1][1] != null && board[2][2] != null) 
		{
			if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) 
			{
				return board[0][0];
			}
		}

		// Check bottom-left to top-right
		if (board[2][0] != null && board[1][1] != null && board[0][2] != null) 
		{
			if (board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2])) 
			{
				return board[1][1];
			}
		}

		return null;
	}
}
