package menu;

import input.InputUtility;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import sharedObject.RenderableHolder;

public class TowerMenu extends StackPane { //Add VBox or maybe use stackpane with imageview as button
	public TowerMenu(int width,int height) {
		super();
		this.setPrefSize(width, height);
		this.setStyle("-fx-background-color:Black;");
		
		//----Draw Background-----
		Canvas background = new Canvas(width,height);
		this.getChildren().add(background);
		GraphicsContext gc = background.getGraphicsContext2D();
		gc.drawImage(RenderableHolder.towerMenuSprite, 0, 0);
		//------------------------
		
		//----menu----
		VBox menu = new VBox();
		Button button = new Button("Tower 1");
		InputUtility.setBuyButton(button, 1);
		menu.getChildren().add(button);
		this.getChildren().add(menu);
	}
}
