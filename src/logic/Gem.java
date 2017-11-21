package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Gem extends CollidableEntity{
	int hp;
	
	public Gem(int row,int column) {
		super();
		this.radius = 12;
		this.x = Field.getPositionX(column);
		this.y = Field.getPositionY(row);
		this.z = -100;
		this.hp=30;
	}
	public void update() {
		for(Enemy enemy: GameLogic.getEnemy()) {
			if(collideWith(enemy)) {
				this.hp -= 1;
				enemy.destroyed = true;
			}
		}
	}
	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setStroke(Color.BLACK);
		gc.setFill(Color.GREEN);
		gc.fillArc(x-radius, y-radius, radius*2, radius*2, 0, 360, ArcType.OPEN);
	}
}
