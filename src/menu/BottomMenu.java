package menu;

import input.InputUtility;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import sharedObject.RenderableHolder;


public class BottomMenu extends StackPane { //add GridPane or maybe use stackpane with imageview as button
	public BottomMenu(double width,double height) {
		super();
		this.setPrefHeight(height);
		this.setPrefWidth(width);
		this.setPrefSize(width, height);
		this.setStyle("-fx-background-color:blue;");
		
		//----Draw Background-----
		Canvas background = new Canvas(width,height);
		this.getChildren().add(background);
		GraphicsContext gc = background.getGraphicsContext2D();
		gc.drawImage(RenderableHolder.bottomMenuSprite, 0, 0);
		//------------------------
		//-----Menu (GridPane)
		GridPane menu = new GridPane();
	
		Button sellButton = new Button("sell");
		InputUtility.setSellButton(sellButton);
		menu.add(sellButton, 0, 0);
		//-----------------
		this.getChildren().add(menu);
	}
}
