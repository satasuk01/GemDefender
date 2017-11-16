package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class ArrowTower extends Tower {
	public ArrowTower(int row,int column){
		this.price = 50;
		this.damage = 10;
		this.splashAttack = false;
		this.range = 60;
		this.fireRate = 10;
		this.fireCount = 0;
		this.radius = 10;
		this.row = row;
		this.column = column;
		this.x = Field.getPositionX(column);
		this.y = Field.getPositionY(row);
	}
	
	private void Attack() {
		int nearestDistance = range;
		Enemy lockedEnemy = null;;
		for(Enemy enemy : GameLogic.getEnemy()) {
			if(inRange(enemy)<=nearestDistance) {
				nearestDistance = inRange(enemy);
				lockedEnemy = enemy;
			}
			
		}
		if(lockedEnemy != null) {
			lockedEnemy.getHit(damage);
			//System.out.println("attakc");
		}
		nearestDistance = range;
		lockedEnemy = null;
	}
	
	@Override
	public void update() {
		//----------Attack-------
		if(fireCount > fireRate) {
			Attack();
			fireCount = 0;
		}
		fireCount ++;
		//----------------------
		
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		//-----Draw Attack Range----
		gc.setLineWidth(1.0);
		gc.strokeArc(x-range, y-range, range*2, range*2, 0, 360, ArcType.OPEN);
		//-----Draw radius----------
		gc.setFill(Color.BLUE);
		gc.fillArc(x-radius, y-radius, radius*2, radius*2, 0, 360, ArcType.OPEN);
	}
}
