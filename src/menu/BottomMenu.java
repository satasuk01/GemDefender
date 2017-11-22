package menu;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import sharedObject.RenderableHolder;


public class BottomMenu extends Pane { //add GridPane

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
		
		
	}
	
}
