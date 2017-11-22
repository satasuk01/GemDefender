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

public class TowerMenu extends Pane { //Add VBox
	public static int bottom = 0;
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
		ImageView tower1 = new ImageView(new Image("file:res/1.png")); tower1.setFitWidth(35); tower1.setFitHeight(35);
		tower1.setLayoutX(7); tower1.setLayoutY(40);
		ImageView tower2 = new ImageView(new Image("file:res/2.png")); tower2.setFitWidth(35); tower2.setFitHeight(35);
		tower2.setLayoutX(7);tower2.setLayoutY(80);
		ImageView remove = new ImageView(new Image("file:res/remove.png")); remove.setFitWidth(35); remove.setFitHeight(35);
		remove.setLayoutX(7);remove.setLayoutY(120);
		this.getChildren().addAll(tower1,tower2,remove);
		//------------------------
		
		//set event for each bottom
		tower1.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent t) {      	
				bottom = 1;
			}
		});
		tower2.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent t) {      	
				bottom = 2;
			}
		});
		remove.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent t) {      	
				bottom = 3;
				
			}
		});
		
	}
	public  static int getBottom() {
		return bottom;
	}
	public static void setBottom(int x) {
		bottom = x;
		}
}
