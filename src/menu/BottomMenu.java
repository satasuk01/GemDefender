package menu;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import sharedObject.RenderableHolder;


public class BottomMenu extends StackPane { //add GridPane
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
	}
}
