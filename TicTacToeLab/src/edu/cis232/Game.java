package edu.cis232;

public class Game 
{
	private Board board = new Board();;
	private String currentPlayer = "Player1";
	
	public void makeMove(int row, int col)
	{
		System.out.println(currentPlayer);
		//board.updateBoard(row, col, currentPlayer);
		switchPlayer();
	}
	
	public void switchPlayer()
	{
		if (currentPlayer.equals("Player1"))
		{
			currentPlayer = "Player2";
		}
		
		else if (currentPlayer.equals("Player2"))
		{
			currentPlayer = "Player1";
		}
	}
	
	public String getCurrentPlayer()
	{
		return currentPlayer;
	}
}
