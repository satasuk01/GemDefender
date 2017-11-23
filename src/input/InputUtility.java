package input;


import core.GameCore;
import drawing.PaneForRenderImageViews;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
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
	
	public static void setSellButton(ImageView btn) {
		
		EventHandler<MouseEvent> hover = new EventHandler<MouseEvent>(){
			
			@Override
		    public void handle(MouseEvent event) {
				
				if(event.getEventType() == MouseEvent.MOUSE_PRESSED) {
					GameCore.sellTower();
					System.out.println("sell");;
				}
				
			}
		};
		btn.setOnMousePressed(hover);
	}
	
	
	public static void setBuyButton(ImageView btn,int status) {
		
		/*btn.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				GameCore.setBuyStatus(status);
				System.out.println("buy :"+status);
			}
		});*/
		
		EventHandler<MouseEvent> hover = new EventHandler<MouseEvent>(){
			
			@Override
		    public void handle(MouseEvent event) {
				
				if(event.getEventType() == MouseEvent.MOUSE_PRESSED) {
					GameCore.setBuyStatus(status);
					System.out.println("buy :"+status);
				}
				
			}
		};
		btn.setOnMousePressed(hover);
		
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
