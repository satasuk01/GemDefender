package input;

import java.util.ArrayList;

import core.GameCore;
import drawing.PaneForRenderImageViews;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import logic.Tower;

public class InputUtility {

	public static double mouseX,mouseY;
	public static boolean mouseOnScreen = true;
	

	public static void addImageViewEvents(Tower tower) {
		
		EventHandler<MouseEvent> hover = new EventHandler<MouseEvent>(){
			
			@Override
		    public void handle(MouseEvent event) {
				
				if(event.getEventType() == MouseEvent.MOUSE_PRESSED) {
					System.out.println("Clicked");
					GameCore.setSelectedTower(tower);
					//tower.destroy();
				}
				
			}
		};
		tower.getImageView().setOnMousePressed(hover);
	}
	
	public static void setSellButton(Button btn) {
		
		btn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				GameCore.sellTower();
				System.out.println("sell");
			}
		});
		
	}
	
	public static void setBuyButton(Button btn,int status) {
		
		btn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				GameCore.setBuyStatus(status);
				System.out.println("buy :"+status);
			}
		});
		
	}
	
	public static void mouseEventOnField(PaneForRenderImageViews pane) { //for Buy Tower
			EventHandler<MouseEvent> hover = new EventHandler<MouseEvent>(){
			
			@Override
		    public void handle(MouseEvent event) {
				
				mouseX = event.getX();
				mouseY = event.getY();
				//System.out.println(mouseX+" "+mouseY);
				//Calculate row and column
				int row = (int)mouseY/25;
				int column = (int)mouseX/25;
				System.out.println(row+" "+column);
				if(GameCore.getBuyStatus() != 0) {
					GameCore.placeTower(row,column);
				}
			}
		};
		//pane.setOnMouseEntered(hover);
		pane.setOnMousePressed(hover);
		
	}
}
