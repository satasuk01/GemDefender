package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.shape.ArcType;
import sharedObject.RenderableHolder;

public class IceTower extends Tower{
	int duration = 10;
	private ImageView tower;
	
	public IceTower(int row,int column){
		this.price = 80;
		this.damage = 3;
		this.splashAttack = true;
		this.range = 55;
		this.fireRate = 15;
		this.fireCount = 0;
		this.radius = 10;
		this.row = row;
		this.column = column;
		this.x = Field.getPositionX(column);
		this.y = Field.getPositionY(row);
		this.angle = 0;
		this.isDrew = false;
	}
	
	private void Attack() {
		for(Enemy enemy : GameLogic.getEnemy()) {
			if(isInRange(enemy)) {
				enemy.getHit(3);
				enemy.freeze(duration);
			}
		}
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
		tower.setImage(null);
		this.destroyed = true;
	}
}
