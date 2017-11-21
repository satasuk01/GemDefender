package menu;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import sharedObject.RenderableHolder;

public class TowerMenu extends StackPane { //Add VBox
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
	}
}
