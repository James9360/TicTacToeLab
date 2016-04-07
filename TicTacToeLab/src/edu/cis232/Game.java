package edu.cis232;

public class Game 
{
	private Board board;
	private String currentPlayer;
	
	public MoveResult makeMove(int row, int col)
	{
		return null;
	}
	
	public void switchPlayer()
	{
		currentPlayer = "Player1";
	}
	
	public String getCurrentPlayer()
	{
		return currentPlayer;
	}
}
