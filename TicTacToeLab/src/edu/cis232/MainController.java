package edu.cis232;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;

public class MainController 
{ 
	boolean grid00 = false, grid01 = false, grid02 = false, grid10 = false, grid11 = false, grid12 = false,
			grid20 = false, grid21 = false, grid22 = false, player = true, gameOver = false;
	int tieCount = 0;
	Board board = new Board();
	Game game = new Game();
	
    @FXML
    private ImageView imgGrid01;

    @FXML
    private ImageView imgGrid00;

    @FXML
    private ImageView imgGrid02;

    @FXML
    private ImageView imgGrid10;

    @FXML
    private ImageView imgGrid11;

    @FXML
    private ImageView imgGrid12;

    @FXML
    private ImageView imgGrid20;

    @FXML
    private ImageView imgGrid21;

    @FXML
    private ImageView imgGrid22;

    @FXML
    private Label lblMessage;
    
    @FXML
    private Button btnNew;

    @FXML
    private Button btnExit;
    
    Image imgO = new Image(getClass().getResource("OPiece.gif").toString()); //Sets Player 1's piece to an "O"
    Image imgX = new Image(getClass().getResource("XPiece.gif").toString());  //Sets Player 2's piece to an "X"

    @FXML
    /**
     * This runs and collects the grid data and pushes it into a board array in the Board class.
     * @param event MouseEvent
     */
    void selectTile(MouseEvent event) 
    {
    	Object source = event.getSource(); //Assigns the even to an Object
    	if (source instanceof ImageView && !gameOver)
    	{
    		//These statments gather's the event, an Imageview clicked, and snips the numbers at the end of the ID to row and col.
    		String str = ((ImageView)source).getId();
    		String id = str.substring(str.length()-2, str.length());
    		int row = Integer.parseInt(id.substring(0, 1));
    		int col = Integer.parseInt(id.substring(1,2));
    		
    		// THIS CODE ISN'T WORKING. IT IS STILL A WORK IN PROGRESS.
    		/*
    		game.makeMove(row, col);
    		System.out.println(board.checkWin());
    		if (row == 0)
    		{
    			if (col == 0)
    			{
    				grid00 = false;
    			}
    			else if (col == 1)
    			{
    				grid01 = false;
    			}
    			else if (col == 2)
    			{
    				grid02 = false;
    			}
    		}
    		
    		else if (row == 1)
    		{
    			if (col == 0)
    			{
    				grid10 = false;
    			}
    			else if (col == 1)
    			{
    				grid11 = false;
    			}
    			else if (col == 2)
    			{
    				grid12 = false;
    			}
    		}
    		
    		else if (row == 2)
    		{
    			if (col == 0)
    			{
    				grid20 = false;
    			}
    			else if (col == 1)
    			{
    				grid21 = false;
    			}
    			else if (col == 2)
    			{
    				grid22 = false;
    			}
    		}
    		*/
    		
    		/**
    		 * If it is player 1's turn, it will execute this code. It will not assign false until the user clicked a valid open spot.
    		 */
    		if (player == true)
    		{
	    		if (row == 0 && col == 0 && !grid00)
	    		{
	    			imgGrid00.setImage(imgO);	
	    			board.updateBoard(row, col, player);
	    			grid00 = true;
	    			player = false;
	    			
	    		}
	    		else if (row == 0 && col == 1 && !grid01)
	    		{
	    			imgGrid01.setImage(imgO);
	    			board.updateBoard(row, col, player);
	    			grid01 = true;
	    			player = false;    			
	    		}
	    		else if (row == 0 && col == 2 && !grid02)
	    		{
	    			imgGrid02.setImage(imgO);
	    			board.updateBoard(row, col, player);
	    			grid02 = true;
	    			player = false;
	    		}
	    		else if (row == 1 && col == 0 && !grid10)
	    		{
	    			imgGrid10.setImage(imgO);
	    			board.updateBoard(row, col, player);
	    			grid10 = true;
	    			player = false;
	    		}
	    		else if (row == 1 && col == 1 && !grid11)
	    		{
	    			imgGrid11.setImage(imgO);
	    			board.updateBoard(row, col, player);
	    			grid11 = true;
	    			player = false;
	    		}
	    		else if (row == 1 && col == 2 && !grid12)
	    		{
	    			imgGrid12.setImage(imgO);
	    			board.updateBoard(row, col, player);
	    			grid12 = true;
	    			player = false;
	    		}
	    		else if (row == 2 && col == 0 && !grid20)
	    		{
	    			imgGrid20.setImage(imgO);
	    			board.updateBoard(row, col, player);
	    			grid20 = true;
	    			player = false;
	    		}
	    		else if (row == 2 && col == 1 && !grid21)
	    		{
	    			imgGrid21.setImage(imgO);
	    			board.updateBoard(row, col, player);
	    			grid21 = true;
	    			player = false;
	    		}
	    		else if (row == 2 && col == 2 && !grid22)
	    		{
	    			imgGrid22.setImage(imgO);
	    			board.updateBoard(row, col, player);
	    			grid22 = true;
	    			player = false;
	    		}
	    		//System.out.println(row);
	    		//System.out.println(col);
	    		lblMessage.setText("Player 2");
    		}
    		
    		/**
    		 * If it is player 2's turn, it will execute this code. It will not assign true until the user clicked a valid open spot.
    		 */
    		else if (player == false)
    		{
	    		if (row == 0 && col == 0 && !grid00)
	    		{
	    			imgGrid00.setImage(imgX);	
	    			board.updateBoard(row, col, player);
	    			grid00 = true;
	    			player = true;	
	    		}
	    		else if (row == 0 && col == 1 && !grid01)
	    		{
	    			imgGrid01.setImage(imgX);
	    			board.updateBoard(row, col, player);
	    			grid01 = true;
	    			player = true;	
	    		}
	    		else if (row == 0 && col == 2 && !grid02)
	    		{
	    			imgGrid02.setImage(imgX);
	    			board.updateBoard(row, col, player);
	    			grid02 = true;
	    			player = true;	
	    		}
	    		else if (row == 1 && col == 0 && !grid10)
	    		{
	    			imgGrid10.setImage(imgX);
	    			board.updateBoard(row, col, player);
	    			grid10 = true;
	    			player = true;	
	    		}
	    		else if (row == 1 && col == 1 && !grid11)
	    		{
	    			imgGrid11.setImage(imgX);
	    			board.updateBoard(row, col, player);
	    			grid11 = true;
	    			player = true;	
	    		}
	    		else if (row == 1 && col == 2 && !grid12)
	    		{
	    			imgGrid12.setImage(imgX);
	    			board.updateBoard(row, col, player);
	    			grid12 = true;
	    			player = true;	
	    		}
	    		else if (row == 2 && col == 0 && !grid20)
	    		{
	    			imgGrid20.setImage(imgX);
	    			board.updateBoard(row, col, player);
	    			grid20 = true;
	    			player = true;	
	    		}
	    		else if (row == 2 && col == 1 && !grid21)
	    		{
	    			imgGrid21.setImage(imgX);
	    			board.updateBoard(row, col, player);
	    			grid21 = true;
	    			player = true;
	    		}
	    		else if (row == 2 && col == 2 && !grid22)
	    		{
	    			imgGrid22.setImage(imgX);
	    			board.updateBoard(row, col, player);
	    			grid22 = true;
	    			player = true;	
	    		}   
	    		lblMessage.setText("Player 1");
    		}
    	}
    	//Checks if the checkWin() method doesn't return null.
    	if (board.checkWin() != null)
    	{
    		System.out.println("The Winner is " + board.checkWin()); //Console testing code.
    		lblMessage.setText("Player " + board.checkWin() + " wins!");
    		gameOver = true;
    	}
    	//Checks if the board is a tie.
    	if (board.isTie())
    	{	
    		System.out.println("Tie!"); //Console testing code.
    		lblMessage.setText("Tie!");
    		gameOver = true;
    		tieCount++;
    	}
    	//This is a little Easter egg I had to make. It is a Wargames reference, quite fitting. It plays after 5 ties. Then the counter resets.
    	if (tieCount == 5)
    	{
    		lblMessage.setText("The only winning move is not to play!");
    		tieCount = 0;
    	}
    }
    
    /**
     * Starts a new game.
     */
    @FXML
    void newClicked()
    {
    	grid00 = false; 
    	grid01 = false;
		grid02 = false;
		grid10 = false;
		grid11 = false;
		grid12 = false;
		grid20 = false;
		grid21 = false;
		grid22 = false;
		player = true;	
		imgGrid00.setImage(null);
		imgGrid01.setImage(null);
		imgGrid02.setImage(null);
		imgGrid10.setImage(null);
		imgGrid11.setImage(null);
		imgGrid12.setImage(null);
		imgGrid20.setImage(null);
		imgGrid21.setImage(null);
		imgGrid22.setImage(null);
    	board = new Board();
    	lblMessage.setText("Player 1");
    	gameOver = false;
    }
    
    /**
     * Exists the program.
     */
    @FXML
    void exitClicked()
    {
    	System.exit(0);
    }
}