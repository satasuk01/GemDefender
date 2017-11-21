package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Spawner extends Entity {
	int radius;
	private int wave;
	public Spawner(int row,int column) {
		super();
		this.radius = 12;
		this.x = Field.getPositionX(column);
		this.y = Field.getPositionY(row);
		this.z = -100;
		this.wave = 1;
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
	
	public void startWave(int wave) {
		//At wave one enemy HP should be 100 and speed is 1
		wave++;
	}
	
	public int getWave() {
		return wave;
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}
}
