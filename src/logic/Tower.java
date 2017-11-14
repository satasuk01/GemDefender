package logic;

public abstract class Tower extends Entity {
	protected int price;
	protected int range;
	protected int damage;
	protected boolean splashAttack;
	protected int fireRate;
	protected int fireCount;
	protected int inRange(Enemy enemy){
		return (int) Math.hypot(this.x-enemy.x, this.y-enemy.y);
	}
	

}
