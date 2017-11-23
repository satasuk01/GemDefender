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
		
		//-----HP Bar-----------
		if(hp>0) {
			gc.fillText(Integer.toString(hp), x-radius, y-radius + 12);
			int c = (int)(255 *(double)(hp)/(double)(30));
			gc.setFill(Color.rgb(100, c, 0));
			gc.fillRect(x-12.5, y-16, 25*(double)(hp)/(double)(30), 3);
		}
		//-------------------------
				
				
	}
}
