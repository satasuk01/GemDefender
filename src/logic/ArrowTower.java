package logic;

import javafx.scene.image.ImageView;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import sharedObject.RenderableHolder;

public class ArrowTower extends Tower {
	private ImageView tower;
	
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
		this.angle = 0;
		this.isDrew = false;
		this.destroyed = false;
		this.eventAdded = false;
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
		//----change angle to enemy-----
		
		//------------
	}
	

	@Override
	public void draw(GraphicsContext gc) {
		//-----Draw Attack Range----
		gc.setLineWidth(1.0);
		gc.strokeArc(x-range, y-range, range*2, range*2, 0, 360, ArcType.OPEN);
	}
	
	@Override
	public ImageView drawImageView() {
		tower = new ImageView(RenderableHolder.arrowTowerSprite);
		tower.relocate(x-12.5, y-12.5);
		tower.setRotate(angle);
		isDrew = true;
		return tower;
	}
	

	
	@Override
	public void move() {
		tower.setLayoutX(x-12.5);
		tower.setLayoutY(y-12.5);
		tower.setRotate(angle);
	}
	@Override
	public void destroy() {
		//tower.setVisible(false);
		tower.setImage(null);
		this.destroyed = true;
	}
	@Override
	public ImageView getImageView() {
		return tower;
	}
}
