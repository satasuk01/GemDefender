package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Spawner extends Entity {
	int radius;
	public Spawner(int row,int column) {
		super();
		this.radius = 12;
		this.x = Field.getPositionX(column);
		this.y = Field.getPositionY(row);
		this.z = -100;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setLineWidth(2.0);
		gc.setStroke(Color.BLACK);
		gc.setFill(Color.AQUAMARINE);
		gc.fillArc(x-radius, y-radius, radius*2, radius*2, 0, 360, ArcType.OPEN);
		//System.out.println("Spawner draw");
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}
}
