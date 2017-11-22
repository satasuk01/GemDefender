package logic;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import menu.BottomMenu;
import sharedObject.RenderableHolder;

public class BuildTower extends Tower {
	private ImageView bt;
	public int x,y,towernum;
	public boolean isClicked = false ; 
	
	public BuildTower(int towernum) {
		this.isDrew =false;
		this.destroyed = false;
		this.towernum = towernum;
	}
	public ImageView drawImageView() {
		bt = new ImageView(new Image("file:res/1.png"));
		
		bt.setLayoutX(-40); bt.setLayoutY(0); bt.setFitWidth(790); bt.setFitHeight(600);
		bt.setOpacity(0);
		bt.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent t) {      	
				y = (int)((t.getSceneX())/25);
				x = (int)((t.getSceneY())/25);
				buildTower();
				bt.setImage(null);
				destroy();
				
			}
		});

		this.isDrew=true;
		return bt;
	}
	
	public void destroy() {
		this.destroyed = true;
	}

	public void draw(GraphicsContext gc) {
	}

	public void update() {
	}
	public void move() {
	}
	public void buildTower() {
		if(towernum == 1){
			ArrowTower Tower = new ArrowTower(x,y);
			GameLogic.addNewObject(Tower);
		}
		if(towernum ==2) {
			IceTower Tower = new IceTower(x,y);
			GameLogic.addNewObject(Tower);
		}
	}
}
