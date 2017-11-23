package drawing;

import input.InputUtility;
import javafx.scene.layout.Pane;
import logic.Tower;
import sharedObject.RenderableHolder;

//This should be call every time when add the tower or sell it

public class PaneForRenderImageViews extends Pane {
	public PaneForRenderImageViews(int width,int height) {
		this.setPrefSize(width, height);
	}
	
	public void paintImageView() {
		for (Tower entity : RenderableHolder.getInstance().getTowers()) {
			// System.out.println(entity.getZ());
			
			//--------Draw the tower on the first time------
			if (entity.isVisible() && !entity.isDestroyed() && !entity.isDrew()) {
				try {
					this.getChildren().add(entity.drawImageView());
					//System.out.println("Tower added");
					System.out.println("added"+entity.toString());
				}
				catch(Exception e) {
					
					
				}
			}
			//----------------------------------------------
			
			//---------Add event handler for Tower
			if (entity.isVisible() && !entity.isDestroyed() && !entity.isEventAdded()) {
				try {
					InputUtility.addImageViewEvents(entity);
				}
				catch(Exception e) {
				}
			}
			//-------------------------------------
			entity.move();
		}
	}
}
