package edu.cis232;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MainController 
{ 
	boolean player = true;
	boolean grid00 = false, grid01 = false, grid02 = false, grid10 = false, grid11 = false, grid12 = false,
			grid20 = false, grid21 = false, grid22 = false;
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
    
    Image imgO = new Image(getClass().getResource("OPiece.gif").toString());
    Image imgX = new Image(getClass().getResource("XPiece.gif").toString());  

    @FXML
    void selectTile(MouseEvent event) 
    {
    	Object source = event.getSource();
    	if (source instanceof ImageView)
    	{
    		String str = ((ImageView)source).getId();
    		String id = str.substring(str.length()-2, str.length());
    		int row = Integer.parseInt(id.substring(0, 1));
    		int col = Integer.parseInt(id.substring(1,2));
    		if (player == true)
    		{
	    		if (row == 0 && col == 0 && !grid00)
	    		{
	    			imgGrid00.setImage(imgO);	
	    			grid00 = true;
	    			player = false;
	    		}
	    		else if (row == 0 && col == 1 && !grid01)
	    		{
	    			imgGrid01.setImage(imgO);
	    			grid01 = true;
	    			player = false;
	    		}
	    		else if (row == 0 && col == 2 && !grid02)
	    		{
	    			imgGrid02.setImage(imgO);
	    			grid02 = true;
	    			player = false;
	    		}
	    		else if (row == 1 && col == 0 && !grid10)
	    		{
	    			imgGrid10.setImage(imgO);
	    			grid10 = true;
	    			player = false;
	    		}
	    		else if (row == 1 && col == 1 && !grid11)
	    		{
	    			imgGrid11.setImage(imgO);
	    			grid11 = true;
	    			player = false;
	    		}
	    		else if (row == 1 && col == 2 && !grid12)
	    		{
	    			imgGrid12.setImage(imgO);
	    			grid12 = true;
	    			player = false;
	    		}
	    		else if (row == 2 && col == 0 && !grid20)
	    		{
	    			imgGrid20.setImage(imgO);
	    			grid20 = true;
	    			player = false;
	    		}
	    		else if (row == 2 && col == 1 && !grid21)
	    		{
	    			imgGrid21.setImage(imgO);
	    			grid21 = true;
	    			player = false;
	    		}
	    		else if (row == 2 && col == 2 && !grid22)
	    		{
	    			imgGrid22.setImage(imgO);
	    			grid22 = true;
	    			player = false;
	    		}
	    		//System.out.println(row);
	    		//System.out.println(col);
	    		lblMessage.setText("Player 2");
    		}
    		else if (player == false)
    		{
	    		if (row == 0 && col == 0 && !grid00)
	    		{
	    			imgGrid00.setImage(imgX);	
	    			grid00 = true;
	    			player = true;	
	    		}
	    		else if (row == 0 && col == 1 && !grid01)
	    		{
	    			imgGrid01.setImage(imgX);
	    			grid01 = true;
	    			player = true;	
	    		}
	    		else if (row == 0 && col == 2 && !grid02)
	    		{
	    			imgGrid02.setImage(imgX);
	    			grid02 = true;
	    			player = true;	
	    		}
	    		else if (row == 1 && col == 0 && !grid10)
	    		{
	    			imgGrid10.setImage(imgX);
	    			grid10 = true;
	    			player = true;	
	    		}
	    		else if (row == 1 && col == 1 && !grid11)
	    		{
	    			imgGrid11.setImage(imgX);
	    			grid11 = true;
	    			player = true;	
	    		}
	    		else if (row == 1 && col == 2 && !grid12)
	    		{
	    			imgGrid12.setImage(imgX);
	    			grid12 = true;
	    			player = true;	
	    		}
	    		else if (row == 2 && col == 0 && !grid20)
	    		{
	    			imgGrid20.setImage(imgX);
	    			grid20 = true;
	    			player = true;	
	    		}
	    		else if (row == 2 && col == 1 && !grid21)
	    		{
	    			imgGrid21.setImage(imgX);
	    			grid21 = true;
	    			player = true;	
	    		}
	    		else if (row == 2 && col == 2 && !grid22)
	    		{
	    			imgGrid22.setImage(imgX);
	    			grid22 = true;
	    			player = true;	
	    		}   
	    		lblMessage.setText("Player 1");
    		}
    	}
    	gameOver();
    }
    
    void gameOver()
    {
    	if (grid00 && grid01 && grid02 && grid10 && grid11 && grid12 && grid20 && grid21 && grid22)
    	{
    		lblMessage.setText("Game Over!");
    	}
    }
}


