package edu.cis232.tictactoe;

public class Board {
	String[][] board = new String[3][3];
	
	/**
	 * Determines a winner by checking rows and columns and 
	 * diagonals.
	 * @return the winning player (X or 0). 
	 * Returns null if there is no winner
	 */
	public String checkWin(){
		String winner = null;
		//Check rows
		winner = checkRowWinner();
		//Check columns
		if(winner == null){
			winner = checkColWinner();
		}
		
		if(winner == null){
			winner = checkDiagonalWinner();
		}
		
		return winner;
	}

	private String checkRowWinner() {
		String winner = null;
		for(int row = 0; row < board.length; row++){
			boolean hasNull = false;
			for(int col = 0; col < board[row].length; col++){
				//Check if there is a null first
				if(board[row][col] == null){
					hasNull = true;
				}
			}
			
			boolean hasDifferent = false;
			String player = board[row][0];
			if(!hasNull){
				//Check if winner
				for(int col = 1; col < board[row].length; col++){
					if(!player.equals(board[row][col])){
						hasDifferent = true;
					}
				}
			}
			
			if(!hasNull && !hasDifferent){
				winner = player;
			}
		}
		
		return winner;
	}
	
	private String checkColWinner() {
		String winner = null;
		
		for(int col = 0; col < board[0].length; col++){
			boolean hasNull = false;
			for(int row = 0; row < board.length; row++){
				//Check if there is a null first
				if(board[row][col] == null){
					hasNull = true;
				}
			}
			
			boolean hasDifferent = false;
			String player = board[0][col];
			if(!hasNull){
				//Check if winner
				for(int row = 1; col < board.length; row++){
					if(!player.equals(board[row][col])){
						hasDifferent = true;
					}
				}
			}
			
			if(!hasNull && !hasDifferent){
				winner = player;
			}
		}
		
		return winner;
	}
	
	private String checkDiagonalWinner(){
		//Check top-left to bottom-right
		if(board[0][0] != null && board[1][1] != null && board[2][2] != null){
			if(board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])){
				return board[0][0];
			}
		}
		
		//Check bottom-left to top-right
		if(board[2][0] != null && board[1][1] != null && board[0][2] != null){
			if(board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2])){
				return board[1][1];
			}
		}
		
		return null;
	}
}
