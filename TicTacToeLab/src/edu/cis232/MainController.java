package edu.cis232;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MainController 
{ 
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
    	/*
    	if (source == imgGrid00)
    	{
    		System.out.println("Grid 0 0 clicked!");
    	}*/
    	
    	if (source instanceof ImageView)
    	{
    		String str = ((ImageView)source).getId();
    		String id = str.substring(str.length()-2, str.length());
    		int row = Integer.parseInt(id.substring(0, 1));
    		int col = Integer.parseInt(id.substring(1,2));
    				
    		//System.out.println(row);
    		//System.out.println(col);
    	}
    }   
}


