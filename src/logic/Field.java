package logic;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import menu.BottomMenu;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class Field implements IRenderable{
	public static int[][] field = new int[30][20]; //one block 25x25px
	
	public static double getPositionX(int column) {
		return column*25+12.5;
	}
	public static double getPositionY(int row) {
		return row*25+12.5;
	}
	public int getTerrain(int row,int column) {
		if(row>75 || column>50 || column<0 || row<0) {
			return -1;
		}
		return field[row][column];
	}
	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public int getZ() {
		return -999;
	}
	@Override
	public void draw(GraphicsContext gc) {
		Image img = RenderableHolder.mapSprite;
		gc.drawImage(img, 0, 0);
	}
	
	
}
