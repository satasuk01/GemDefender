package logic;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public abstract class Tower extends Entity {
	protected int row;
	protected int column;
	
	protected int price;
	protected int radius;
	protected int range;
	protected int damage;
	protected boolean splashAttack;
	protected int fireRate;
	protected int fireCount;
	protected double angle;
	protected boolean isDrew;
	protected int inRange(Enemy enemy){
		return (int) Math.hypot(this.x-enemy.x, this.y-enemy.y);
	}
	protected boolean isInRange(Enemy enemy) {
		return Math.hypot(this.x-enemy.x, this.y-enemy.y) <= this.range+enemy.radius;
	}
	public int getRow() {
		return row;
	}
	public int getColumn() {
		return column;
	}
	public boolean isDrew() {
		return isDrew;
	}
	public abstract void update();
	public abstract ImageView drawImageView();

	public abstract void move();
	public abstract void destroy();
	
}
