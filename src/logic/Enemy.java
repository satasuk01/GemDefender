package logic;

public class Enemy extends CollidableEntity {
	private int maxHp;
	private int hp;
	private double normalSpeed;
	private double speed;
	private boolean freezed = false;
	private int freezedDuration = 0;
	private int angle = 0;
	
	public Enemy(int maxHp,int normalSpeed) {
		speed = normalSpeed/2;
		maxHp = maxHp;
		hp = maxHp;
		this.radius = X;
	}
	private void move() {
		
	}
	public void getHit(int damage) {
		this.hp -= damage;
	}
	public void freeze(int duration) {
		speed = normalSpeed/2;
		freezed = true;
		freezedDuration=duration;
		
	}
	public void update() {
		//Decrease freeze time
		if(freezed) {
			freezedDuration--;
			if(freezedDuration<=0) {
				freezed = false;
				speed = normalSpeed;
			}
		}
		//--------------------
		if(hp<=0) {
			this.destroyed = true;
		}
	}
	
	//---------Getters and Setters--------------
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public boolean isFreezed() {
		return freezed;
	}
	public void setFreezed(boolean freezed) {
		this.freezed = freezed;
	}
	//------------------------------------------
	
}
